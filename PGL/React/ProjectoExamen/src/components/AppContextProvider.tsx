import React, { Dispatch, SetStateAction, useContext, createContext, useState } from 'react'
import { Pelicula } from '../hooks/Types';

type Props = {}

export interface AppContextType {
    peliculasFavoritas: Array<Pelicula>;
    token: string;
    setPeliculasFavoritas: Dispatch<SetStateAction<Array<Pelicula>>>
    setToken: Dispatch<SetStateAction<string>>
}

export const AppContext = createContext<AppContextType>({} as AppContextType);

export const AppContextProvider = (props: any) => {
    const [peliculas, setPeliculas] = useState<Array<Pelicula>>([] as Array<Pelicula>);
    const [token, setToken] = useState("");
    const contextValues: AppContextType = {
        peliculasFavoritas: peliculas,
        token: token,
        setToken: setToken,
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