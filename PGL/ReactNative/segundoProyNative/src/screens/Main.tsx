import { View, Text, Image, TouchableHighlight, Modal, StyleSheet, Alert, Pressable } from 'react-native'
import React, { useState } from 'react'
import styles from '../themes/styles'
import Icon from 'react-native-vector-icons/Ionicons';
import AntNest from '../components/AntNest';
import { Button } from 'react-native-elements';
import NestDetails from '../components/NestDetails';

type Props = {}

type Hormiguero = {
    id: number,
    img: string,
    antname: string,
    biome: string,
}

const Main = (props: Props) => {
    const [modalVisible, setModalVisible] = useState(false);
    const [actual, setActual] = useState(0);

    let hormigueros: Array<Hormiguero> = 
    [
        {id: 0, img: '../img/Hormiga-negra.jpg', antname: 'Hormiga Negra', biome: 'Planicie'}, 
        {id: 1, img: '../img/Cotadora-de-hojas.jpg', antname: 'Hormina Cortadora De Hojas', biome: 'Pantano'}, 
        {id: 2, img: '../img/hormiga-roja.jpeg', antname: 'Hormiga Roja', biome: 'Humedales'},
        {id: 3, img: '../img/hormiga-roja.jpeg', antname: 'Hormiga Roja', biome: 'Humedales'},    
    ];

    function showModal(index: number) {
        setModalVisible(true);
        setActual(index);
    }

    function closeModal(){
        setModalVisible(false);
    }

    return (
        <View style={styles.container}>
            <View style={styles.profileBar}>
                <Image
                    style={styles.profilePicture}
                    source={require('../img/profile.png')}
                />
                <Text style={styles.title}>Nombre Perfil</Text>

                <TouchableHighlight style={styles.icono}>
                    <Icon name="menu-outline" size={40}/>
                </TouchableHighlight>
                
            </View>
            <View style={styles.mainConatiner}>
                <Text style={styles.title}>Hormigueros</Text>
                    {
                        hormigueros.map((value, index) => {
                            return <AntNest key={index} nest={value} showModal={showModal}/>
                        })
                    }
            </View>            
            
            <Modal
                animationType="fade"
                transparent={true}
                visible={modalVisible}
                onRequestClose={() => setModalVisible(false)}
            >
                <NestDetails closeModal={closeModal} hormiguero={hormigueros[actual]}/>
            </Modal>
        </View>
    )
}

export default Main