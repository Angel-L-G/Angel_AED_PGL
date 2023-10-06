<?php
    class Product{
        public $id;
        public $name;
        public $category;
        public $stock;
        public $price;

        public function __construct(string $n, string $c, int $s, int $p, int $i){
            $this->name = $n;
            $this->category = $c;
            $this->stock = $s;
            $this->price = $p;
            $this->id = $i;
        }

        public function __toString(){
            return  
            "Name: ".$this->name.
            " Id: ".$this->id."<br/>".
            "Category: ".$this->category."<br/>".
            "Stock: ".$this->stock."<br/>".
            "Price: ".$this->price."<br/>";
        }
    }
?>