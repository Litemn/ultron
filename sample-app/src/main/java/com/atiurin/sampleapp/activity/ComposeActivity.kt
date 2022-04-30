package com.atiurin.sampleapp.activity

import android.os.Bundle
import android.preference.PreferenceActivity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.atiurin.sampleapp.data.entities.Contact
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.atiurin.sampleapp.async.ContactsPresenter
import com.atiurin.sampleapp.async.GetContacts
import com.atiurin.sampleapp.async.UseCase
import com.atiurin.sampleapp.data.repositories.ContactRepositoty
import com.atiurin.sampleapp.data.viewmodel.ContactsViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ComposeActivity : ComponentActivity() {
    val model: ContactsViewModel by viewModels()
    @ExperimentalUnitApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactsObserver = Observer<List<Contact>> {
            setContent {
                Column {
                    ButtonWithCount()
                    ContactsList(contacts = ContactRepositoty.all())
                }
            }
        }
        model.contacts.observe(this, contactsObserver)
        GlobalScope.async {
            GetContacts()(
                UseCase.None,
                onSuccess = { model.contacts.value = it },
                onFailure = { Toast.makeText(this@ComposeActivity, "Failed to load contacts", Toast.LENGTH_LONG).show() }
            )
        }
    }
}

@ExperimentalUnitApi
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
            Text(text = "Section")
        }
        items(contacts, key = { c -> c.name } ) { contact ->
            Text(contact.name, fontSize = TextUnit(16f, TextUnitType.Sp) )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = contact.status)
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.Black)
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
        Text("Like count = ${count.value}",
            modifier = Modifier.semantics { testTag = "text_container" }
        )
    }
}