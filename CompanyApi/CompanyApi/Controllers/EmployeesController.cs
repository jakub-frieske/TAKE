using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using CompanyApi.Models;

namespace CompanyApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeesController : ControllerBase
    {
        private readonly CompanyDbContext _context;

        public EmployeesController(CompanyDbContext context)
        {
            _context = context;
        }

        // GET: api/Employees
        [HttpGet]
        public async Task<ActionResult<IEnumerable<EmployeeDTO>>> GetEmployees()
        {
          if (_context.Employees == null)
          {
              return NotFound();
          }
            return await _context.Employees
                .Select(e => EmployeeToDTO(e))
                .ToListAsync();
        }

        // GET: api/Employees/5
        [HttpGet("{id}")]
        public async Task<ActionResult<EmployeeDTO>> GetEmployee(int id)
        {
          if (_context.Employees == null)
          {
              return NotFound();
          }
            var employee = await _context.Employees.FindAsync(id);

            if (employee == null)
            {
                return NotFound();
            }

            return EmployeeToDTO(employee);
        }

        // PUT: api/Employees/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutEmployee(int id, EmployeeDTO employeeDTO)
        {
            if (id != employeeDTO.EmployeeId)
            {
                return BadRequest();
            }

            _context.Entry(DTOToEmployee(employeeDTO)).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EmployeeExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Employees
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<EmployeeDTO>> PostEmployee(EmployeeDTO employeeDTO)
        {
          if (_context.Employees == null)
          {
              return Problem("Entity set 'CompanyDbContext.Employees'  is null.");
          }
            _context.Employees.Add(DTOToEmployee(employeeDTO));
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetEmployee", new { id = employeeDTO.EmployeeId }, employeeDTO);
        }

        // DELETE: api/Employees/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<EmployeeDTO>> DeleteEmployee(int id)
        {
            if (_context.Employees == null)
            {
                return NotFound();
            }
            var employee = await _context.Employees.FindAsync(id);
            if (employee == null)
            {
                return NotFound();
            }

            _context.Employees.Remove(employee);
            await _context.SaveChangesAsync();

            return EmployeeToDTO(employee);
        }

        private bool EmployeeExists(int id)
        {
            return (_context.Employees?.Any(e => e.EmployeeId == id)).GetValueOrDefault();
        }

        private static EmployeeDTO EmployeeToDTO(Employee employee) =>
         new EmployeeDTO
         {
             EmployeeId = employee.EmployeeId,
             FirstName = employee.FirstName,
             LastName = employee.LastName,
             ManagerId = employee.ManagerId,
             Salary = employee.Salary,
             Bonus = employee.Bonus,
             DepartmentId = employee.DepartmentId
         };
        private static Employee DTOToEmployee(EmployeeDTO employeeDTO) =>
        new Employee
        {
            EmployeeId = employeeDTO.EmployeeId,
            FirstName = employeeDTO.FirstName,
            LastName = employeeDTO.LastName,
            ManagerId = employeeDTO.ManagerId,
            Salary = employeeDTO.Salary,
            Bonus = employeeDTO.Bonus,
            DepartmentId = employeeDTO.DepartmentId
        };
    }
}
