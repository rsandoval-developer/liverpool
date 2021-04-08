package com.liverpool.app.presentation.ui.search

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.mauker.materialsearchview.MaterialSearchView
import com.google.android.material.snackbar.Snackbar
import com.liverpool.app.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.content_search.*
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var searchViewModelFactory: SearchViewModelFactory

    private val searchViewModel: SearchViewModel by lazy {
        ViewModelProvider(this, searchViewModelFactory).get(SearchViewModel::class.java)
    }

    private var page = 1
    private val numberOfItemsPerPage = 20


    private val adapter: SearchAdapter by lazy {
        SearchAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_search)
        setSupportActionBar(this.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        this.initAdapter()
        this.initObserveViewModel()
        this.initSearchView()

    }

    private fun initSearchView() {
        this.searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchViewModel.search(
                    query,
                    page,
                    numberOfItemsPerPage
                )
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    private fun initAdapter() {
        this.searchRV.layoutManager = GridLayoutManager(this, 2)
        this.searchRV.adapter = this.adapter
    }

    private fun initObserveViewModel() {
        this.searchViewModel.searchViewModelState.observe(this, Observer { state ->
            when (state) {
                is SearchViewModelState.SearchSucces -> {
                    this.adapter.updateSearch(state.search)
                }
                is SearchViewModelState.ProgressVisibility -> {
                    this.loading.visibility = state.visibility
                    this.searchRV.visibility =
                        if (state.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
                }
                is SearchViewModelState.ErrorState -> {
                    this.content?.let {
                        Snackbar.make(it, state.error, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle toolbar item clicks here. It'll
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_search -> {
                // Open the search view on the menu item click.
                searchView.openSearch()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (searchView.isOpen) {
            // Close the search on the back button press.
            searchView.closeSearch()
        } else {
            super.onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            val matches = data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (matches != null && matches.size > 0) {
                val searchWrd = matches[0]
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false)
                }
            }
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onPause() {
        super.onPause()
        searchView.clearSuggestions()
    }

    override fun onResume() {
        super.onResume()
        searchView.activityResumed()
    }

    private fun clearHistory() {
        searchView.clearHistory()
    }

    private fun clearSuggestions() {
        searchView.clearSuggestions()
    }

    private fun clearAll() {
        searchView.clearAll()
    }
}