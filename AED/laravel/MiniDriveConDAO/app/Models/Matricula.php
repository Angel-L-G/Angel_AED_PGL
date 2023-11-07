<?php
    namespace App\Models;

    use App\Models\Alumno;

    class Matricula{
        private $idmatricula;
        private Alumno $alumno;
        private $year;
        private $asignaturas = [];
        
        public function getIdmatricula(){
            return $this->idmatricula;
        }

        public function setIdmatricula($id){
            $this->idmatricula = $id;
        }

        public function getAlumno(){
            return $this->alumno;
        }

        public function setAlumno($a){
            $this->alumno = $a;
        }

        public function getYear(){
            return $this->year;
        }

        public function setYear($f){
            $this->year = $f;
        }

        public function getAsignaturas(){
            return $this->asignaturas;
        }

        public function setAsignaturas($arr){
            $this->asignaturas = $arr;
        }

        public function __toString(){
            $asinaturasStr = "";
            foreach ($this->asignaturas as $key => $value) {
                $asinaturasStr .= $value->getNombre() . "<br/>";
            }

            return "Alumno: " .
            $this->alumno->getnombre() . " " . $this->alumno->getApellidos() .
            " Id: " . $this->getIdmatricula() . 
            " Year:" . $this->getYear() . 
            " Asignaturas: " . $asinaturasStr;
        }
    }
?>