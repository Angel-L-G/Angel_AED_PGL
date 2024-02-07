<?php

namespace App\Http\Controllers;

use App\Http\Resources\AlumnoResource;
use App\Models\Alumno;
use Illuminate\Http\Request;

class AlumnoController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $list = Alumno::all();
        //response()->json($list);
        return response()->json($list);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $obj = Alumno::create([
            'dni' => $request->dni,
            'nombre' => $request->nombre,
            'apellido' => $request->apellido,
            'fechanacimiento' => $request->fechanacimiento,
            'imagen' => $request->imagen
        ]);

        //response()->json($obj);
        return new AlumnoResource($obj);
    }

    /**
     * Display the specified resource.
     */
    public function show(Alumno $alumno)
    {
        $obj = Alumno::find($alumno->dni);
        return new AlumnoResource($obj);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Alumno $alumno)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Alumno $alumno)
    {
        $alumno->delete();
        return response()->json(null,204);
    }
}
