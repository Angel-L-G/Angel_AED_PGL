<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;
use PDO;
use Illuminate\Support\Facades\DB;
use App\Models\Alumno;
use App\DAO\AlumnoDAO;

use function PHPUnit\Framework\assertTrue;

class AlumnoDaoTest extends TestCase{

    public  $databaseCreated = false;

    public function setUp(): void{
        parent::setUp();

        if(! $this->databaseCreated ){
            $pdo = DB::getPdo();
            //new pdo();
            require 'CreateDatabase.php';
            $this->databaseCreated = true;
        }
    }


    public function test_1_findAll(): void {
        $pdo = DB::getPdo();

        $alumnoDAO = new AlumnoDAO($pdo);
        $alumnos = $alumnoDAO->findAll();
        assertTrue(count($alumnos) == 3);
    }

    public function test_2_save(): void {
        $pdo = DB::getPdo();

        $AlumnoDAO = new AlumnoDAO($pdo);
        $a = new Alumno();
        $a->setNombre("unaasignatura");
        $a->setApellidos("unapellidos");
        $a->setFechaNac(1234567890);

        $alumno = $AlumnoDAO->save($a);
        $alumnos = $AlumnoDAO->findAll();
        echo count($alumnos);
        assertTrue(count($alumnos) == 4);
        assertTrue(null != $alumno->getDni());
        assertTrue($alumno->getDni() > 0 );
    }


    public function test_3_findbyid(): void {
        $pdo = DB::getPdo();

        $asignaturaDAO = new AlumnoDAO($pdo);

        $obtenido = $asignaturaDAO->findById("12345678Z");

        assertTrue(isset($obtenido));

        assertTrue( ("12345678Z" == $obtenido->getDni() ) );
    }
}
