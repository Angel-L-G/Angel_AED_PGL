import React, {createContext, useContext, useState, Dispatch, SetStateAction} from 'react'

export interface AppContextType {
    url: string;
    setUrl: Dispatch<SetStateAction<string>>
}

export const AppContext = createContext<AppContextType>({} as AppContextType)

export const AppContextProvider = (props: any) => {
    const [urlSt, seturl] = useState<string>({} as string);
    const contextValues: AppContextType = {
        url: urlSt,
        setUrl: seturl
    };
    return (
        <AppContext.Provider value={contextValues}>
            {props.children}
        </AppContext.Provider>
    );
}

export const useAppContext = () => {
    return useContext(AppContext);
}

export default AppContextProvider