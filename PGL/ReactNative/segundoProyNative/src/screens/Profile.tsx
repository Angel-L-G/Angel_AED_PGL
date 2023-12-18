import { View, Text, Image, FlatList, TouchableHighlight } from 'react-native'
import React from 'react'
import styles from '../themes/styles'

type Props = {
    navigation: any
}

type User = {
    id: number,
    name: string,
}

const Profile = ({navigation}: Props) => {
    const arrAmigos: Array<User> = [
        {
            id: 0,
            name: 'Julio',
        },
        {
            id: 1,
            name: 'Juanma',
        },
        {
            id: 2,
            name: 'Owen',
        },
        {
            id: 3,
            name: 'Javier',
        },
        {
            id: 4,
            name: 'Angel',
        },
    ];

    return (
        <View style={styles.container}>
            <View style={styles.mainConatiner}>
                <Image
                    style={styles.bigProfilePicture}
                    source={require('../img/profile.png')}
                />

                <Text style={styles.title}>Nombre Perfil</Text>

                <View style={styles.textBodyContainer}>
                    <Text style={styles.textBody}>
                        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Minima illo, nemo neque repellat perferendis cupiditate molestiae error fuga dolorum cum fugiat saepe iste deserunt esse minus non architecto exercitationem placeat.
                    </Text>
                </View>

                <View style={styles.friendProfileList}>
                    <FlatList 
                        data={arrAmigos}
                        renderItem={({item}) => (
                            <TouchableHighlight onPress={() => navigation.navigate("Social")}>
                                <Text style={styles.friendProfileItem}>{item.name}</Text>
                            </TouchableHighlight>
                        )}
                    />
                </View>
            </View>
        </View>
    )
}

export default Profile