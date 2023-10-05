import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Contador from './Practica8';
import Tabla from './Practica9';
import Practica10 from './Practica10';
import ComponenteEstatico from "./Practica11";
import Practica12 from './Practica12';
import Practica13 from './Practica13';
import Practica14 from './Practica14';
import Practica15 from './Practica15';
import Practica16 from './Practica16';
import Practica17 from './Practica17';
import EjEffect from './EjEffect';
import reportWebVitals from './reportWebVitals';
import ComponenteApp from './ComponenteApp';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <EjEffect />
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
