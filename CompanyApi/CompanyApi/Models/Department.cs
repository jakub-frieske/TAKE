using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace CompanyApi.Models
{
    [Table("Department")]
    public partial class Department
    {
        public Department()
        {
            Employees = new HashSet<Employee>();
        }

        [Key]
        public int DepartmentId { get; set; }
        [StringLength(20)]
        [Unicode(false)]
        public string? Name { get; set; }

        [InverseProperty(nameof(Employee.Department))]
        public virtual ICollection<Employee> Employees { get; set; }
    }
}
