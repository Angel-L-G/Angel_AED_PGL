<?php
    class Anotacion{
        //public $id;

        public $author;

        public $titel;

        public $desc;

        public $date;

        public function __construct(string $a, string $t, string $de, float $da){
            //$this->id = $id;
            $this->author = $a;
            $this->titel = $t;
            $this->desc = $de;
            $this->date = $da;
        }

        public function __toString(){
            return 
                "Titel: ".$this->titel."<br/>".
                " Author: ".$this->author."<br/>".
                " Description: ".$this->desc."<br/>".
                " Date: ".$this->date;
        }
    }
?>