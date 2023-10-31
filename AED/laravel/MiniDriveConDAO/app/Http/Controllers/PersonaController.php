<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\DAO\PersonaDAO;
use App\Models\Persona;

class PersonaController extends Controller
{
    public function obtenerPersonas(Request $request){
        $pdo = DB::getPdo();
        $personaDAO = new PersonaDAO($pdo);

        $personas = $personaDAO->findAll();
        print_r($personas);
    }

    public function guardarPersonas(Request $request){
        $pdo = DB::getPdo();
        $personaDAO = new PersonaDAO($pdo);

        $p = new Persona();

        $p->setId(25);
        $p->setNombre("Prueba");
        $p->setEdad(22);

        $personaDAO->save($p);
    }

    public function updatePersona(Request $request){
        $pdo = DB::getPdo();
        $personaDAO = new PersonaDAO($pdo);

        $p = new Persona();

        $p->setId(25);
        $p->setNombre("PruebaUpdate");
        $p->setEdad(300);

        $personaDAO->update($p);
    }

    public function deletePersona(Request $request){
        $pdo = DB::getPdo();
        $personaDAO = new PersonaDAO($pdo);

        $id = 26;

        $personaDAO->delete($id);
    }
}
