<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodo="addTodo"></TodoInput>
    <TodoList v-bind:propsdata="todoItems" @removeTodo="removeTodo"></TodoList>
    <TodoFooter v-on:removeAll="clearAll"></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader'
import TodoInput from './components/TodoInput'
import TodoList from './components/TodoList'
import TodoFooter from './components/TodoFooter'
export default {
  data () {
    return {
      todoItems: []
    }
  },
  created () {
  // ????
  },
  methods: {
    addTodo (todoItem) {
      this.$http.get('/todo/addTodo/' + todoItem).then().catch()
      this.todoItems.push(todoItem)
    },

    clearAll () {
      this.$http.get('/todo/deleteAll').then().catch()
      this.todoItems = []
    },
    removeTodo (todoItem, index) {
      this.todoItems.splice(index, 1)
      this.$http.get('/todo/delete/' + ++index).then().catch()
    }
  },
  components: {
    'TodoHeader': TodoHeader,
    'TodoInput': TodoInput,
    'TodoList': TodoList,
    'TodoFooter': TodoFooter
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color: #F6F6F8;
  }
  input {
    border-style: groove;
    width: 200px;
  }
  button {
    border-style: groove;
  }
  .shadow {
    box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
  }
</style>
