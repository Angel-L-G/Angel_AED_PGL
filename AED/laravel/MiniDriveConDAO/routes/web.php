<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

use App\Http\Controllers\MatriculaController;
use App\Http\Controllers\AsignaturaController;
use App\Http\Controllers\AlumnoController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\HomeController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

/*
Route::any("/personas/mostrar", [PersonaController::class, "obtenerPersonas"]);
Route::any("/personas/save", [PersonaController::class, "guardarPersonas"]);
Route::any("/personas/update", [PersonaController::class, "updatePersona"]);
Route::any("/personas/delete", [PersonaController::class, "deletePersona"]);
*/

Auth::routes();
Route::any('/',[MatriculaController::class, 'showIndex']);

Route::any('/asignaturas',[AsignaturaController::class, 'index']);
Route::any('/createAsig',[AsignaturaController::class, 'create']);
Route::any('/deleteAsig',[AsignaturaController::class, 'delete']);
Route::any('/updateAsig',[AsignaturaController::class, 'update']);
Route::any('/showAsig',[AsignaturaController::class, 'show']);

Route::any('/alumnos',[AlumnoController::class, 'index']);
Route::any('/createAlum',[AlumnoController::class, 'create']);
Route::any('/deleteAlum',[AlumnoController::class, 'delete']);
Route::any('/updateAlum',[AlumnoController::class, 'update']);
Route::any('/showAlum',[AlumnoController::class, 'show']);

Route::any('/matriculas',[MatriculaController::class, 'index']);
Route::any('/createMatr',[MatriculaController::class, 'create']);
Route::any('/deleteMatr',[MatriculaController::class, 'delete']);
Route::any('/updateMatr',[MatriculaController::class, 'update']);
Route::any('/showMatr',[MatriculaController::class, 'show']);