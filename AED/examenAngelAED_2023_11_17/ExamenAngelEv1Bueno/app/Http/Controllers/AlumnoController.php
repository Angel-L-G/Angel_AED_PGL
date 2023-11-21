<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\DAO\AlumnoDAO;
use App\Models\Alumno;

class AlumnoController extends Controller
{
    public function index(Request $request){
        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);

        $alumnos = $alumnoDAO->findAll();
        
        return view("Alumnos",compact("alumnos"));
    }

    public function create(Request $request){
        $nombre = request()->get("nombre");
        $curso = request()->get("apellidos");
        $nacimiento = request()->get("nacimiento");
        $dni = request()->get("dni");

        $a = new Alumno();

        $a->setNombre($nombre);
        $a->setApellidos($curso);
        $a->setFechaNac($nacimiento);
        $a->setDni($dni);

        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);

        $res = $alumnoDAO->save($a);

        if($res == null){
            echo "Algo salio mal";
        }

        $alumnos = $alumnoDAO->findAll();
        
        return view("Alumnos",compact("alumnos"));
    }

    public function delete(Request $request){
        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);

        $dni = request()->get("dni");
        $bool = $alumnoDAO->delete($dni);

        if($bool == true){
            echo "Algo salio mal";
        }

        $alumnos = $alumnoDAO->findAll();
        
        return view("Alumnos",compact("alumnos"));
    }

    public function update(Request $request){
        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);

        $nombre = request()->get("nombre");
        $curso = request()->get("apellidos");
        $nacimiento = request()->get("nacimiento");
        $dni = request()->get("dni");

        $a = new Alumno();

        $a->setNombre($nombre);
        $a->setApellidos($curso);
        $a->setFechaNac($nacimiento);
        $a->setDni($dni);

        $res = $alumnoDAO->update($a);

        if($res == true){
            echo "Algo salio mal";
        }

        $alumnos = $alumnoDAO->findAll();
        
        return view("Alumnos",compact("alumnos"));
    }

    public function show(Request $request){
        $dni = request()->get("dni");

        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);

        $alumnos[] = $alumnoDAO->findById($dni);

        return view("Alumnos",compact("alumnos"));
    }
}
