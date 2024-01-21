import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f4f4f4',
    },
    title: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 20,
    },
    form: {
        width: '80%',   
    },
    input: {
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        marginBottom: 15,
        padding: 10,
        borderRadius: 5,
    },
    button: {
        backgroundColor: '#3498db',
        padding: 15,
        borderRadius: 5,
        alignItems: 'center',
    },
    buttonText: {
        color: '#fff',
        fontWeight: 'bold',
    },
    text: {
        fontSize: 16,
        textAlign: 'center',
        color: '#333',
        lineHeight: 24,
    },
    link: {
        color: '#3498db',
        textDecorationLine: 'underline',
    },
    userName: {
        fontSize: 18,
        color: '#333',
    },
    userContainer: {
        padding: 15,
        borderBottomWidth: 1,
        borderBottomColor: '#ddd',
        width: '100%',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    buttonContainer: {
        flex: 1,
        flexDirection: 'row',
        flexWrap: "wrap",
        marginLeft: 150,
    },
    editButton: {
        backgroundColor: '#3498db',
        padding: 10,
        borderRadius: 5,
        marginRight: 10,
    },
    deleteButton: {
        backgroundColor: '#e74c3c',
        padding: 10,
        borderRadius: 5,
    },
    backButton: {
        backgroundColor: 'green',
        padding: 10,
        borderRadius: 5,
    },
    label: {
        fontSize: 16,
        marginBottom: 5,
    },
    foto: {
        width: 100,
        height: 100,
        borderRadius: 50,
        marginBottom: 10,
    },
    texto: {
        fontSize: 16,
        marginBottom: 8,
    },
});

export default styles;