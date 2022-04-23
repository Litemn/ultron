package com.atiurin.sampleapp.activity

import android.os.Bundle
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.atiurin.sampleapp.data.entities.Contact
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import com.atiurin.sampleapp.data.repositories.ContactRepositoty

class ComposeActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ButtonWithCount()
                ContactsList(contacts = ContactRepositoty.all())
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(contacts: List<Contact>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.semantics {
            contentDescription = "contacts_list"
        }
    ) {
        stickyHeader {
            PreferenceActivity.Header()
        }
        items(contacts) { contact ->
            Text(contact.name)
            Text(text = contact.status)
        }
    }
}

@Composable
fun ButtonWithCount(){
    var count = remember {
        mutableStateOf(0)
    }
    Button(onClick = { count.value++},  modifier = Modifier.semantics {
        testTag = "likes_counter"
        contentDescription = "likes_counter" },

    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = null
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like count = ${count.value}", modifier = Modifier.semantics { testTag = "text_container" })
    }
}