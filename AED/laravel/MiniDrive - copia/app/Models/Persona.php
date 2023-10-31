<?php
    namespace App\Models;

    class Persona{
        public $id;

        public $nombre;

        public $edad;

        function __construct(/*$id, $nombre, $edad*/){
            /*$this->id = $id;
            $this->nombre = $nombre;
            $this->edad = $edad;*/
        }

        public function getId(){
            return $this->id;
        }

        public function setId($id){
            $this->id = $id;
            return $this;
        }

        public function getNom(){
            return $this->nombre;
        }

        public function setNombre($nombre){
            $this->nombre = $nombre;
            return $this;
        }

        public function getedad(){
            return $this->edad;
        }

        public function setedad($edad){
            $this->edad = $edad;
            return $this;
        }
    }

?>
