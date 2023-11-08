<?php

namespace App\Http\Controllers;

use App\DAO\AlumnoDAO;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\DAO\MatriculaDAO;
use App\DAO\AsignaturaDAO;
use App\Models\Matricula;

class MatriculaController extends Controller{
    public function showIndex(){
        return view("Principal");
    }

    public function index(){
        $pdo = DB::getPdo();
        $matriculaDAO = new MatriculaDAO($pdo);

        $matriculas = $matriculaDAO->findAll();

        $asignaturaDAO = new AsignaturaDAO($pdo);

        $asignaturas = $asignaturaDAO->findAll();
        
        return view("Matricula",compact("matriculas", "asignaturas"));
    }

    public function create(Request $request){
        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);        
        $asignaturaDAO = new AsignaturaDAO($pdo);
        $matriculaDAO = new MatriculaDAO($pdo);

        $year = request()->get("year");
        $dni = request()->get("dni");
        $asignaturas = request()->input("asignaturas",[]);
        $id = request()->get("id");

        $m = new Matricula();

        $m->setYear($year);
        $m->setIdmatricula($id);

        $a = $alumnoDAO->findById($dni);
        $m->setAlumno($a);

        $aux = [];
        foreach ($asignaturas as $key => $value) {
            $aux[] = $asignaturaDAO->findById($value);
        }

        $m->setAsignaturas($aux);

        $res = $matriculaDAO->save($m);

        $matriculas = $matriculaDAO->findAll();
        $asignaturas = $asignaturaDAO->findAll();
        
        return view("Matricula",compact("matriculas","asignaturas"));
    }

    public function delete(Request $request){
        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);        
        $asignaturaDAO = new AsignaturaDAO($pdo);
        $matriculaDAO = new MatriculaDAO($pdo);

        $id = request()->input("id");

        $bool = $matriculaDAO->delete($id);

        $matriculas = $matriculaDAO->findAll();
        $asignaturas = $asignaturaDAO->findAll();
        
        return view("Matricula",compact("matriculas","asignaturas"));
    }

    public function update(Request $request){
        $pdo = DB::getPdo();
        $alumnoDAO = new AlumnoDAO($pdo);        
        $asignaturaDAO = new AsignaturaDAO($pdo);
        $matriculaDAO = new MatriculaDAO($pdo);

        $year = request()->get("year");
        $dni = request()->get("dni");
        $asignaturas = request()->input("asignaturas",[]);
        $id = request()->get("id");

        $m = new Matricula();

        $m->setYear($year);
        $m->setIdmatricula($id);

        $a = $alumnoDAO->findById($dni);
        $m->setAlumno($a);

        $aux = [];
        foreach ($asignaturas as $key => $value) {
            $aux[] = $asignaturaDAO->findById($value);
        }

        $m->setAsignaturas($aux);

        $res = $matriculaDAO->update($m);

        $matriculas = $matriculaDAO->findAll();
        $asignaturas = $asignaturaDAO->findAll();
        
        return view("Matricula",compact("matriculas","asignaturas"));
    }

    public function show(Request $request){
        $id = request()->get("id");

        $pdo = DB::getPdo();
        $matriculaDAO = new MatriculaDAO($pdo);
        $asignaturaDAO = new AsignaturaDAO($pdo);

        $matriculas[] = $matriculaDAO->findById($id);
        $asignaturas = $asignaturaDAO->findAll();
        
        return view("Matricula",compact("matriculas","asignaturas"));
    }
}
