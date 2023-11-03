<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

use App\Http\Controllers\PersonaController;

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

Route::any("/personas/mostrar", [PersonaController::class, "obtenerPersonas"]);
Route::any("/personas/save", [PersonaController::class, "guardarPersonas"]);
Route::any("/personas/update", [PersonaController::class, "updatePersona"]);
Route::any("/personas/delete", [PersonaController::class, "deletePersona"]);
