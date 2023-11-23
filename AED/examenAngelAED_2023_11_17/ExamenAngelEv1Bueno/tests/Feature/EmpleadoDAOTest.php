<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use PDO;
use Tests\TestCase;
use App\Models\Empleado;
use App\DAO\EmpleadoDAO;
use function PHPUnit\Framework\assertTrue;

class EmpleadoDAOTest extends TestCase
{
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

        $empleadoDAO = new EmpleadoDAO($pdo);
        $empleado = $empleadoDAO->findAll();
        assertTrue(count($empleado) == 5);
    }


    public function test_2_findbyid(): void {
        $pdo = DB::getPdo();

        $empleadoDAO = new EmpleadoDAO($pdo);

        $obtenido = $empleadoDAO->findById("22");

        assertTrue(isset($obtenido));

        assertTrue( ("22" == $obtenido->getId() ) );
        assertTrue( ("Ana" == $obtenido->getNombre() ) );
    }

    public function test_3_save(): void {
        $pdo = DB::getPdo();

        $empleadoDAO = new EmpleadoDAO($pdo);

        $jefe = $empleadoDAO->findById(10);

        $a = new Empleado();

        $a->setId(1);
        $a->setNombre("PRUEBA");
        $a->setApellidos("a");
        $a->setFechaContrato(123456789);

        $a->setJefe($jefe);

        $a->setNumero(9);
        $a->setCalle("calle");
        $a->setMunicipio("muni");

        $empleado = $empleadoDAO->save($a);
        $empleados = $empleadoDAO->findAll();


        assertTrue(count($empleados) == 6);
        assertTrue(isset($empleado) );
        assertTrue($empleado->getNombre() == "PRUEBA");
        assertTrue($empleado->getApellidos() == "a");
        assertTrue($empleado->getFechaContrato() == 123456789);
        assertTrue($empleado->getJefe()->getId() == 10);

        assertTrue($empleado->getNumero() == 9);
        assertTrue($empleado->getCalle() == "calle");
        assertTrue($empleado->getMunicipio() == "muni");

        print_r($empleado);
    }

    public function test_4_update(){
        $pdo = DB::getPdo();

        $empleadoDAO = new EmpleadoDAO($pdo);

        $jefe = new Empleado();

        $jefe->setId(10);

        $a = new Empleado();

        $a->setId(1);
        $a->setNombre("PRUEBA");
        $a->setApellidos("a");
        $a->setFechaContrato(123456789);

        $a->setJefe($jefe);

        $a->setNumero(9);
        $a->setCalle("calle");
        $a->setMunicipio("muni");

        $empleado = $empleadoDAO->save($a);
        $empleados = $empleadoDAO->findAll();


        assertTrue(count($empleados) == 6);
        assertTrue(isset($empleado) );
        assertTrue($empleado->getNombre() == "PRUEBA");
        assertTrue($empleado->getApellidos() == "a");
        assertTrue($empleado->getFechaContrato() == 123456789);
        assertTrue($empleado->getJefe()->getId() == 10);
        assertTrue($empleado->getNumero() == 9);
        assertTrue($empleado->getCalle() == "calle");
        assertTrue($empleado->getMunicipio() == "muni");

        $bool = $empleadoDAO->update($a);
        assertTrue($bool);
    }

    public function test_5_delete(){
        $pdo = DB::getPdo();

        $empleadoDAO = new EmpleadoDAO($pdo);

        //Este empleado es jefe por lo tanto tiene que fallar
        $bool = $empleadoDAO->delete("22");
        echo "Bool = ".$bool;
        assertTrue(!$bool);

        $bool = $empleadoDAO->delete("10");
        echo "Bool = ".$bool;
        assertTrue($bool);
    }
}
