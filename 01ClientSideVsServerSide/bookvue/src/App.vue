<template>
  <h1>Hello World</h1>

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
        const results = response.data.results
        this.books = results.map(book => ({
          title: book.title,
          author: book.author
        }))
      } catch (err) {
        if (err.response) {
          // client received an error response (5xx, 4xx)
          this.error = {
            title: "Server Response",
            message: err.message,
          }
        } else if (err.request) {
          // client never received a response, or request never left
          this.error = {
            title: "Unable to Reach Server",
            message: err.message,
          }
        } else {
          // There's probably an error in your code
          this.error = {
            title: "Application Error",
            message: err.message,
          }
        }
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
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
