import React, { Dispatch, SetStateAction, createContext, useContext, useState } from 'react';

type Tarea = {
    id: number,
    titulo: string,
    estado: boolean
}

export interface AppContextType {
    tareasContext: Array<Tarea>;
    setTareasContext: Dispatch<SetStateAction<Array<Tarea>>>
}

export const AppContext = createContext<AppContextType>({} as AppContextType);

export const AppContextProvider = (props: any) => {
    const [tareasContext, setTareasContext] = useState<Array<Tarea>>([]);
    
    const contextValues: AppContextType = {
        tareasContext: tareasContext,
        setTareasContext: setTareasContext
    };

    return (
        <AppContext.Provider value={contextValues}>
            {props.children}
        </AppContext.Provider>
    )
}

export const useAppContext = () => {
    return useContext(AppContext);
}

export default AppContextProvider;