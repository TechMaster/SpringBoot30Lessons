<template>
<div class="container outer">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark col-md-12">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <select class="custom-select" @change="sorting($event)">
                            <option disabled selected>Sort By</option>
                            <option value="price">Price</option>
                            <option value="asc">A-Z</option>
                            <option value="desc">Z-A</option>
                        </select>
                    </li>
                </ul>
                <div class="mx-5">
                    <router-link to="/cart">
                        <i class="fas fa-cart-plus"></i> {{ count }}
                    </router-link>
                </div>
                <form class="form-inline my-2 my-lg-0 mx-3" @submit.prevent="searchText">
                    <input v-model="content" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                        Search
                    </button>
                </form>
            </div>
        </nav>
    </div>

    <h1 class="title">Features Product</h1>

    <div class="loading " style="height:20px; width: 20px;" v-if="isLoading">
        <span class="spinner-border text-primary"></span>
    </div>
    <div class="row justify-content-around" style="background:#343a40;" v-else>
        <div class="card col-md-3 mx-3 my-3 bg-dark border-0" v-for="product in products" :key="product.id" style="width: 18rem;">
            <img class="card-img-top img-fluid" alt="Card image cap" :src="require(`../assets/watch${product.id}.jpg`)" />
            <div class="card-body text-center">
                <h5 class="card-title">{{ product.name }}</h5>
                <p class="card-text">
                    <span style="color:#a8741a;">${{ product.price }}</span><br />
                    <span>{{ product.description }}</span>
                </p>
                <button class="btn btn-primary" @click="addToCart(product.id)">
                    Add to Cart
                </button>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from "axios";
export default {
    name: "Home",
    data() {
        return {
            products: [],
            count: 0,
            content: "",
            cart: {},
            isLoading: true
        };
    },
    methods: {
        async addToCart(id) {

            await axios.get(`http://localhost:8100/api/buy/${id}`)
                .then((res) => {
                    this.cart = res.data;
                })
            await axios.get("http://localhost:8100/api/getCount")
                .then(res => this.count = res.data);
        },

        async searchText() {
            // if(this.content.length>0){
            //   this.products = this.products.filter(item=>{
            //       return item.name.toLowerCase().includes(this.content.toLowerCase())
            //     })
            // }
            // else{
            //      axios.get("http://localhost:4000/products").then(res=>{
            //         this.products = res.data
            //       })
            // }
            await axios
                .get(`http://localhost:8100/api/products?search=${this.content}`)
                .then((res) => (this.products = res.data));
        },
        async sorting(event) {
            await axios
                .get(`http://localhost:8100/api/products?sort=${event.target.value}`)
                .then((res) => (this.products = res.data));
        },
    },

    async created() {
        
        await axios
            .get("http://localhost:8100/api/products")
            .then((res) => {
                this.products = res.data;

            })
            .catch((err) => console.log(err));
        await axios.get("http://localhost:8100/api/cart")
            .then(res => {
                this.cart = res.data;
                if (this.cart.orderList.length > 0) {
                    this.cart.orderList.map(order => {
                        this.count = order.count + this.count;
                    })
                }
            })
        this.isLoading = false;
    },
};
</script>

<style scoped>
.outer {
    background: #343a40;
    color: aliceblue;
    height: 100vh;
}

.title {
    text-align: center;
    font-size: 48px;
    text-transform: capitalize;
    margin-top: 50px;
}

.card-img-top {
    transition: 0.2s;
    border: 50%;
}

.card-img-top:hover {
    cursor: pointer;
    transform: scale(1.1);
}

.loading {
  margin-left: auto;
  margin-right: auto;
  margin-top: 40%;
  margin-bottom:auto;  
}
</style>
