<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

use App\Http\Controllers\UserController;
use App\Http\Controllers\FileController;

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
Route::any("/", function() {return view("Login");});
Route::any('/showRegister', function() {return view("Register");});
Route::any('/Register', [UserController::class,'Register']);
Route::any('/showLogin', function() {return view("Login");});
Route::any('/logIn', [UserController::class, 'logIn']);
Route::any('/logOut', [UserController::class, 'logOut']);

Route::any('/ShowUpload', function() {return view("Upload");});
Route::any('/Upload', [FileController::class, 'UploadFile']);
Route::any('/showFiles', [FileController::class, 'showFiles']);

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
