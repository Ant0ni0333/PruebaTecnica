package com.example.examplemvvm.domain

    import com.example.examplemvvm.data.model.QuoteRepository
    import com.example.examplemvvm.domain.model.Quote
    import io.mockk.MockKAnnotations
    import io.mockk.coEvery
    import io.mockk.coVerify
    import io.mockk.impl.annotations.RelaxedMockK
    import junit.framework.TestCase
    import kotlinx.coroutines.runBlocking
    import org.junit.Before
    import org.junit.Test

//import org.junit.jupiter.api.Test

class GetQuotesUseCaseTest {

    //Declaramos el repository que ocuparemos en la prueba unitaria
    // Empleamos RelaxedMockk para generar autmáticamente una respuesta
    // en caso de que el repository acceda a algo que no hemos preparado
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    // Declaramos el caso de uso
    lateinit var getQuotesUseCase: GetQuotesUseCase

    // Iniciamos el @Before para la prueba unitaria
    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        // Instanciamos el caso de uso compartiendo su repositorio correspondiente
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    // Declaramos el caso de prueba de dos posibles maneras:
    @Test
    fun whenTheApiDoesntReturnAnythingThenGetValuesFromDatabaseJoined() = runBlocking {
        //Given: Empleamos "coEvery" porque tenemos corrutinas, de no tenerlas, emplearíamos solo "every"
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        //When: el método a probar del caso de uso
        getQuotesUseCase()

        //Then: Verificamos lo que sucederá al ser llamado el método
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }
    }

    // Podemos usar la tilde inversa para declarar nombres con espacios:
    @Test
    fun `when The Api Doesnt Return Anything Then Get Values From Database`() = runBlocking {

        //Given: Empleamos "coEvery" porque tenemos corrutinas, de no tenerlas, emplearíamos solo "every"
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        //When: el método a probar del caso de uso
        getQuotesUseCase()

        //Then: Verificamos lo que sucederá al ser llamado el método
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }

    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given: Empleamos "coEvery" porque tenemos corrutinas, de no tenerlas, emplearíamos solo "every"

        val myList = listOf(Quote("Rob phrase for unit test","Rob"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList

        //When: el método a probar del caso de uso
        val response = getQuotesUseCase()

        //Then: Verificamos lo que sucederá al ser llamado el método

        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDatabase() }
        assert(myList == response)
    }

}