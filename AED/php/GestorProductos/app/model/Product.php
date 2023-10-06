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
            $this->name."<br/>".
            $this->id."<br/>".
            $this->category."<br/>".
            $this->stock."<br/>".
            $this->price."<br/>";
        }
    }
?>