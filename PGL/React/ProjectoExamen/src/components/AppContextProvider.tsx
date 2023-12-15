import React, { Dispatch, SetStateAction, useContext, createContext, useState } from 'react'
import { Pelicula } from '../hooks/Types';

type Props = {}

export interface AppContextType {
    peliculasFavoritas: Array<Pelicula>;
    setPeliculasFavoritas: Dispatch<SetStateAction<Array<Pelicula>>>
}

export const AppContext = createContext<AppContextType>({} as AppContextType);

export const AppContextProvider = (props: any) => {
    const [peliculas, setPeliculas] = useState<Array<Pelicula>>([] as Array<Pelicula>);
    const contextValues: AppContextType = {
        peliculasFavoritas: peliculas,
        setPeliculasFavoritas: setPeliculas
    };

    return (
        <AppContext.Provider value={contextValues}>
        {props.children}
        </AppContext.Provider>
    );
};

export const useAppContext = () => {
    return useContext(AppContext);
};

export default AppContextProvider