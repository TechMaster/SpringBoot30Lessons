<template>
  <h1>Book List</h1>
  <BookList :books="books" />
</template>

<script>
import BookList from './components/BookList.vue'
import axios from "axios"
export default {
  components: {
    BookList,
  },
  data() {
    return {
      books: [],
      loading: false,
      error: null,
    }
  },
  methods: {    
    async fetchBooks() {
      try {
        this.error = null
        this.loading = true
        const url = `http://localhost:8080/api/books`
        const response = await axios.get(url)       
        this.books = response.data
      } catch (err) {       
        console.log(err)
      }
      this.loading = false
    },
  },
  mounted() {
    this.fetchBooks()
  },

}
</script>

<style>
#app {
  font-family: "SF Mono", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-top: 20px;
}
</style>
