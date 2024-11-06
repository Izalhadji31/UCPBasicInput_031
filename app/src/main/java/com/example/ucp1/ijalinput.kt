package com.example.ijalinput


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ijalinput(modifier: Modifier = Modifier){

    var Origin by remember { mutableStateOf("") }
    var Departure by remember { mutableStateOf("") }
    var Arrival by remember { mutableStateOf("") }

    var Transport by remember { mutableStateOf("") }

    val listI= listOf("Bus","Ship","Train", "Plane")

    var OriginIjal by remember { mutableStateOf("") }
    var DepartureIjal by remember { mutableStateOf("") }
    var ArrivalIjal by remember { mutableStateOf("") }
    var TransportIjal by remember { mutableStateOf("") }


    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Planes Your Adventures", fontSize = 16.sp, fontWeight = FontWeight.Bold,)
        Spacer(Modifier.padding(10.dp))
        TextField(
            value = Origin,
            onValueChange = {Origin = it},
            label = {
                Text(text = "Origin")
            },
            placeholder = {
                Text(text = "isi Origin anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )


        TextField(
            value = Departure,
            onValueChange = {Departure= it},
            label = {
                Text(text = "Departure")
            },
            placeholder = {
                Text(text = "isi Departure anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = Arrival,
            onValueChange = {Arrival = it},
            label = {
                Text(text = "Arrival")
            },
            placeholder = {
                Text(text = "isi Arrival anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row (modifier = Modifier.fillMaxWidth()){
            listI.forEach{selectedGender ->
                Row (
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = Transport == selectedGender,
                        onClick = { Transport = selectedGender
                        }
                    )
                    Text(text = selectedGender)

                }
            }
        }


        Button(   onClick = {
            OriginIjal = Origin
            DepartureIjal = Departure
            ArrivalIjal = Arrival
            TransportIjal = Transport
        }) {
            Text(text = "Submit")

        }
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Blue)
        ) {
            DetailMessagge(param = "Origin", argum = OriginIjal)
            DetailMessagge(param = "Departure", argum = DepartureIjal)
            DetailMessagge(param = "Arrival", argum = ArrivalIjal)
            DetailMessagge(param = "Transport", argum = TransportIjal)
        }
    }
}

@Composable
fun DetailMessagge(
    param: String, argum: String
){
    Column(
        modifier = Modifier.padding(16.dp))
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
           Text(text = param,
                modifier = Modifier.weight(0.8f)) // memberi ruang seberapa banyak dalam kolon/barisnya
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = argum, //kenapa argum? karena isinya akan digantikan dengan parameter argum
                modifier = Modifier.weight(2f))

        }
    }
}