<?php

namespace App\Models;

class Empleado{
    public $id;
    public $nombre;
    public $apellidos;
    public $fechaContrato;
    public Empleado $jefe;
    public $numero;
    public $calle;
    public $municipio;
    public function __construct(){}

    public function getId(){
        return $this->id;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function getNombre(){
        return $this->nombre;
    }
    public function setNombre($nombre){
        $this->nombre = $nombre;
    }
    public function getApellidos(){
        return $this->apellidos;
    }
    public function setApellidos($apellidos){
        $this->apellidos = $apellidos;
    }
    public function getFechaContrato(){
        return $this->fechaContrato;
    }
    public function setFechaContrato($fechaContrato){
        $this->fechaContrato = $fechaContrato;
    }
    public function getJefe(){
        return $this->jefe;
    }
    public function setJefe($jefe){
        $this->jefe = $jefe;
    }
    public function getNumero(){
        return $this->numero;
    }
    public function setNumero($numero){
        $this->numero = $numero;
    }
    public function getCalle(){
        return $this->calle;
    }
    public function setCalle($calle){
        $this->calle = $calle;
    }
    public function getMunicipio(){
        return $this->municipio;
    }
    public function setMunicipio($municipio){
        $this->municipio = $municipio;
    }

}
