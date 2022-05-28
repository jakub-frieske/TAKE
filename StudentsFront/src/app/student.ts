export class Student {
  id?: number;
  index: number;
  firstName: string;
  lastName: string;
  
  constructor(index: number, firstName: string, lastName: string, id?: number) {
    this.index = index;
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }
}
