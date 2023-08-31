import { Component } from '@angular/core';

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.css']
})
export class ToDoListComponent {

  todos: { text: string; editing: boolean }[] = [];

  newTodo: string = ''; 

  addTodo() {
    if (this.newTodo.trim() !== '') {
      this.todos.push({ text: this.newTodo, editing: false });
      this.newTodo = ''; 
    }
  }

  deleteTodo(index: number) {
    this.todos.splice(index, 1);
  }

  editTodo(index: number) {
    this.todos[index].editing = !this.todos[index].editing;
  }
}
