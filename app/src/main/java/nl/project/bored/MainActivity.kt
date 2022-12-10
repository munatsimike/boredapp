package nl.project.bored

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import nl.project.bored.state.NetworkState
import nl.project.bored.ui.theme.BoredTheme
import nl.project.bored.viewModel.BoredViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoredTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ShowActivity()
                }
            }
        }
    }
}

@Composable
fun ShowActivity(modifier: Modifier = Modifier, boredViewModel: BoredViewModel = hiltViewModel()) {
    val networkResponse by boredViewModel.activity.collectAsState()
    Surface(modifier = modifier.padding(25.dp)) {

        when (networkResponse) {
            NetworkState.Loading -> {
                Row(horizontalArrangement = Arrangement.Center) {
                    CircularProgressIndicator()
                }
            }
            is NetworkState.NetworkError -> {}
            is NetworkState.NetworkSuccess -> {
                val data = networkResponse as NetworkState.NetworkSuccess
                OutlinedCard(
                ) {
                    Column (
                        modifier = modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    )
                    {

                        Text(text = data.activity.activity)
                        Spacer(modifier = modifier.height(35.dp))
                        Button(onClick = {}) {
                            Text(text = stringResource(id = R.string.next_activity))
                        }
                    }
                }
            }
            NetworkState.NotLoading -> {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoredTheme {}
}