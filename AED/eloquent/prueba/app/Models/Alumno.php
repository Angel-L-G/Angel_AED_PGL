<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Alumno extends Model
{
    /**
    * @var string $nombre
    */
    protected $nombre;
    /**
    * @var string $apellido
    *
    */
    protected $apellido;

    /**
    * @var int $edad
    */
    protected $edad;

    function __construct(string $nombre, string $apellido, int $edad){
        $this->nombre = $nombre;
        $this->apellido = $apellido;
        $this->edad = $edad;
    }

    public function getApellido() {
      return $this->apellido;
    }

    public function setApellido($value) {
      $this->apellido = $value;
    }

    public function getEdad() {
      return $this->edad;
    }

    public function setEdad($value) {
      $this->edad = $value;
    }

    public function getNombre() {
      return $this->nombre;
    }

    public function setNombre($value) {
      $this->nombre = $value;
    }
}
