<?php
    namespace App\Models;

    class Alumno{
        private $dni;
        private $nombre;
        private $apellidos;
        private $fechaNac;

        public function getDni(){
            return $this->dni;
        }

        public function setDni($d){
            $this->dni = $d;
        }

        public function getnombre(){
            return $this->nombre;
        }

        public function setNombre($n){
            $this->nombre = $n;
        }

        public function getApellidos(){
            return $this->apellidos;
        }

        public function setApellidos($a){
            $this->apellidos = $a;
        }
        
        public function getFechaNac(){
            return $this->fechaNac;
        }

        public function setFechaNac($f){
            $this->fechaNac = $f;
        }
    }
?>