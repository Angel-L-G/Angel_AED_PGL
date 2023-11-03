<?php

namespace Tests\Feature;

use App\DAO\AsignaturaDAO;
use App\Models\Asignatura;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

use function PHPUnit\Framework\assertNotNull;
use function PHPUnit\Framework\assertTrue;

class AsignaturaDAOTest extends TestCase{

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

        $asignaturaDAO = new AsignaturaDAO($pdo);
        $asignaturas = $asignaturaDAO->findAll();
        assertTrue(count($asignaturas) == 8);
    }

    public function test_2_save(): void {
        $pdo = DB::getPdo();

        $asignaturaDAO = new AsignaturaDAO($pdo);
        $a = new Asignatura();
        $a->setNombre("unaasignatura");
        $a->setCurso("uncurso");

        $asignatura = $asignaturaDAO->save($a);
        $asignaturas = $asignaturaDAO->findAll();
        assertTrue(count($asignaturas) == 9);
        assertTrue(null != $asignatura->getId());
        assertTrue($asignatura->getId() > 0 );
    }


    public function test_3_findbyid(): void {
        $pdo = DB::getPdo();

        $asignaturaDAO = new AsignaturaDAO($pdo);

        $obtenido = $asignaturaDAO->findById(1);

        assertTrue(isset($obtenido));

        assertTrue( (1 == $obtenido->getId() ) );
    }

    public function test_4_update(){
        $pdo = DB::getPdo();

        $asignaturaDAO = new AsignaturaDAO($pdo);

        $a = new Asignatura();
        $a->setId(1);
        $a->setNombre("Updated");
        $a->setCurso("Updated");

        $bool = $asignaturaDAO->update($a);

        assertTrue(!$bool);
    }

    //public function
}

