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

        $alumnoDAO = new AlumnoDAO($pdo);
        $a = new Alumno();
        $a->setNombre("unaasignatura");
        $a->setApellidos("unapellidos");
        $a->setFechaNac(1234567890);

        $alumno = $alumnoDAO->save($a);
        $alumnos = $alumnoDAO->findAll();
        
        assertTrue(count($alumnos) == 4);
        assertTrue(null != $alumno->getDni());
        assertTrue($alumno->getDni() > 0 );
    }


    public function test_3_findbyid(): void {
        $pdo = DB::getPdo();

        $alumnoDAO = new AlumnoDAO($pdo);

        $obtenido = $alumnoDAO->findById("12345678Z");

        assertTrue(isset($obtenido));

        assertTrue( ("12345678Z" == $obtenido->getDni() ) );
    }

    public function test_4_update(){
        $pdo = DB::getPdo();

        $alumnoDAO = new AlumnoDAO($pdo);

        $a = new Alumno();
        $a->setDni("12345678A");
        $a->setNombre("Updated");
        $a->setApellidos("Updated");
        $a->setFechaNac(000000000);

        $bool = $alumnoDAO->update($a);
        assertTrue(!$bool);
    }

    public function test_5_delete(){
        $pdo = DB::getPdo();

        $alumnoDAO = new AlumnoDAO($pdo);

        $bool = $alumnoDAO->delete("12345678Z");
        echo "Bool = ".!$bool;
        assertTrue(!$bool);
    }
}
