import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        width: '100%',
        height: '100%'
    },

    BackgorundImage: {
        position: 'absolute',
        width: '100%',
        height: '100%',
    },

    formContainer: {
        height: 300,
        Width: 60,
        alignItems: 'flex-start',
        textShadowColor: 'rgba(0, 0, 0, 0.75)',
        textShadowOffset: { width: 2, height: 2 },
        textShadowRadius: 5,
        backgroundColor: '#e9e1cc',
        padding: 10,
    },

    innerFormContainer: {
        flex: 1,
    },  

    formTitle: {
        fontSize: 25,
        fontWeight: 'bold',
        alignItems: 'center',
        justifyContent: 'center',
        color: 'black',
    },

    formText: {
        fontSize: 15,
        color: 'black',
        fontWeight: 'bold',
    },

    enlaceText: {
        fontSize: 15,
        textDecorationLine: 'underline',
        color: 'blue',
    },

    button: {
        padding: 10,
        color: 'white',
        border: 'none',
        radius: 4,
        cursor: 'pointer',
        backgroundColor: '#377d72',
        width: 100
    },

    nestViewContainer: {
        marginTop: 10,
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'space-evenly',
        minHeight: 150,
        gap: 15
    },

    nestImage: {
        width: 200,
        height: 100,
    },

    netsButtons: {
        gap: 20,
        alignItems: 'center',
    },

    profileBar:{
        flexDirection: 'row',
        gap: 50,
        justifyContent: 'space-between',
        backgroundColor: "#377d72",
        width: '100%',
        height: 60,
    },

    profilePicture:{
        margin: 5,
        width: 50,
        height: 50,
        borderRadius: 80,
    },

    mainConatiner:{
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        width: '100%',
        backgroundColor: '#483a39',
    },

    title: {
        marginTop: 10,
        marginBottom: 10,
        fontSize: 25,
        color: 'white',
        fontWeight: 'bold',
        alignItems: 'center',
        justifyContent: 'center',
    },

    icono: {
        marginTop: 10,
        width: 50,
        height: 50,
    },

    messageContainer: {
        justifyContent: 'flex-end',
        alignItems: 'flex-start',
        width: '85%',
        backgroundColor: '#c2bcbe',
        gap: 15,
    },

    messageText: {
        fontSize: 20,
        color: 'black',
        fontWeight: 'bold',
    },

    chatContainer: {
        flex: 1,
        flexDirection: 'row',
    },

    friendsScrollConatiner: {
        justifyContent: 'center',
        alignItems: 'center',
        width: '15%',
        backgroundColor: '#11211e',
    },

    friendsText: {
        color: 'white',
    },

    chatInput:{
        width: '100%',
        backgroundColor: '#e9e1cc',
        gap: 15,
    },

    modalContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        margin: '10%',
        backgroundColor: '#7f5f16'
    },

    subTitle: {
        fontSize: 17,
        color: 'black',
        fontWeight: 'bold',
        alignItems: 'center',
        justifyContent: 'center',
    },

    header3: {
        fontSize: 15,
        color: 'black',
        fontWeight: 'bold',
        alignItems: 'center',
        justifyContent: 'center',
    },

    textBody: {
        fontSize: 13,
        color: 'black',
    },

    crearBody: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        width: '100%',
        backgroundColor: '#11211e'
    }
})

export default styles