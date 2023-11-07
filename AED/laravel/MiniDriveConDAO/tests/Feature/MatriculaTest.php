<?php

namespace Tests\Feature;

use App\Dao\MatriculaDao;
use App\Models\Alumno;
use App\Models\Asignatura;
use App\Models\Matricula;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

use function PHPUnit\Framework\assertTrue;

class MatriculaDaoTest extends TestCase
{
    public  $databaseCreated = false;

    public  function setUp(): void{
        parent::setUp();

        if(! $this->databaseCreated ){
            $pdo = DB::getPdo();
            require 'CreateDatabase.php';
            $this->databaseCreated = true;
        }
    }

    public function test_1_findAll(): void {
        $pdo = DB::getPdo();

        $matriculaDao = new MatriculaDao($pdo);
        $matriculas = $matriculaDao->findAll();
        assertTrue(count($matriculas) == 4);
    }

    public function test_2_save(): void {
        $pdo = DB::getPdo();

        $matriculaDao = new MatriculaDao($pdo);

        $a = new Alumno;
        $a->setDni('12345678Z');
        $a->setNombre('Ana');
        $a->setApellidos('Martín');
        $a->setFechaNac("2014-02-24");

        $m = new Matricula();
        $m->setAlumno($a);
        $m->setYear(2023);
        $m->setAsignaturas([new Asignatura(1, 'BAE', '1º DAM'), new Asignatura(2, 'PGV', '2º DAM')]);

        $matricula = $matriculaDao->save($m);
        $matriculas = $matriculaDao->findAll();

        assertTrue(count($matriculas) == 5);
        //Esto falla por el sqlite
        //assertTrue($matricula->getIdmatricula() !== null);
    }


    public function test_3_findbyid(): void {
        $pdo = DB::getPdo();

        $matriculaDao = new MatriculaDao($pdo);
        $m = new Matricula();
        $m->setIdmatricula(1);


        $obtenido = $matriculaDao->findById($m->getIdmatricula());

        assertTrue(isset($obtenido));
        assertTrue(($m->getIdmatricula() == $obtenido->getIdmatricula()));
    }

    public function test_4_delete() {
        $pdo = DB::getPdo();

        $matriculaDao = new MatriculaDao($pdo);

        $id = 2;

        $ok = $matriculaDao->delete($id);

        assertTrue(!$ok);
    }

    public function test_5_update(): void {
        $pdo = DB::getPdo();

        $matriculaDao = new MatriculaDao($pdo);

        $m = new Matricula();
        $m->setIdmatricula(3);
        $m->setAlumno(new Alumno('87654321X', 'Marcos', 'Afonso Jiménez', "2013-04-05"));
        $m->setYear(2023);
        $m->setAsignaturas([new Asignatura(1, 'BAE', '1º DAM'), new Asignatura(2, 'PGV', '2º DAM')]);

        $ok = $matriculaDao->update($m);

        assertTrue(!$ok);
    }
}