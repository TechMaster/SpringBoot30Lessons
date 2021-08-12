package vn.techmaster.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.shoppingcart.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(){
        return new ResponseEntity<>(cartService.getCart(), HttpStatus.OK);
    }


    @GetMapping("/buy/{id}")
    public ResponseEntity<?> buy(@PathVariable("id") Long id){
        cartService.addToCart(id);
        return new ResponseEntity<>(cartService.getCart(),HttpStatus.OK);
    }

    @GetMapping("/add/{id}")
    public ResponseEntity<?> add(@PathVariable("id") Long id){
        cartService.addToCart(id);
        return new ResponseEntity<>(cartService.getCart(),HttpStatus.OK);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id){
        cartService.removeFromCart(id);
        return new ResponseEntity<>(cartService.getCart(),HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity<?> getCount(){
        return new ResponseEntity<>(cartService.getCount(),HttpStatus.OK);
    }

    @PostMapping("/discount/{type}")
    public ResponseEntity<?> discount(@PathVariable("type") String type){
        switch (type){
            case "moon":
                cartService.discount(0.1);
                break;
            case "acer":
                cartService.discount(0.05);
                break;
            default:
                cartService.discount(0);
        }
        return new ResponseEntity<>(cartService.getCart(),HttpStatus.CREATED);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> removeOrder(@PathVariable("id") Long id){
        cartService.removeOrder(id);
        return new ResponseEntity<>(cartService.getCart(),HttpStatus.OK);
    }

}
