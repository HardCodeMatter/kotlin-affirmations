package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
//    fun main() {
//        val numbers = listOf<Int>(1, 2, 3, 4, 5, 6)
//        println("List: $numbers")
//        println("Size: ${numbers.size}")
//
//        // Access elements of the list
//        println("First elem: ${numbers[0]}")
//        println("First elem: ${numbers.first()}")
//        println("Last elem: ${numbers[numbers.size - 1]}")
//        println("Last elem: ${numbers.last()}")
//
//        // Use the contains() method
//        println("Contains 2?: ${numbers.contains(4)}")
//        println("Contains 9?: ${numbers.contains(9)}")
//
//        // Mutable list
//        val entrees = mutableListOf<String>()
//        println("Entrees: $entrees")
//
//        // Add individual items using add()
//        println("Add apple: ${entrees.add("apple")}")
//        println("Entrees: $entrees")
//        println("Add coconut: ${entrees.add("coconut")}")
//        println("Entrees: $entrees")
//
//        // Add a list of items using addAll()
//        val moreItems = listOf("strawberry", "banana", "pineapple")
//        println("Add items: ${entrees.addAll(moreItems)}")
//        println("Entrees: $entrees")
//
//        // Remove an item using remove()
//        println("Remove pineapple: ${entrees.remove("pineapple")}")
//        println("Entrees: $entrees")
//        println("Remove item that doesn't exist: ${entrees.remove("peach")}")
//        println("Entrees: $entrees")
//
//        // Remove an item by index using removeAt()
//        println("Remove second elem: ${entrees.removeAt(1)}")
//        println("Entrees: $entrees")
//
//        // Clear out the list
//        entrees.clear()
//        println("Entrees: $entrees")
//
//        // Check if the list is empty
//        println("Empty?: ${entrees.isEmpty()}")
//
//        // Loop through a list of names
//        val names = listOf("Dmytro", "Alex", "Rodger", "Matthew", "Mike")
//        for (name in names) {
//            println("$name - number of characters: ${name.length}")
//        }
//    }

    open class Item(val name: String, val price: Int)

    class Noodles : Item("Noodles", 10) {
        override fun toString(): String {
            return name
        }
    }

    class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
        override fun toString(): String {
            if (toppings.isEmpty()) {
                return "$name chef's choice"
            } else {
                return name + " " + toppings.joinToString()
            }
        }
    }

    class Order(val orderNumber: Int) {
        private val itemList = mutableListOf<Item>()

        fun addItem(newItem: Item): Order {
            itemList.add(newItem)
            return this
        }

        fun addAll(newItems: List<Item>): Order {
            itemList.addAll(newItems)
            return this
        }

        fun print() {
            println("Order #${orderNumber}")
            var total = 0
            for (item in itemList) {
                println("${item}: $${item.price}")
                total += item.price
            }
            println("Total: $${total}")
        }
    }

    fun main() {
        val ordersList = mutableListOf<Order>()

        // Add an item to an order
        val orderOne = Order(1)
        orderOne.addItem(Noodles())
        ordersList.add(orderOne)

        // Add multiple items
        val orderTwo = Order(2)
        orderTwo.addItem(Noodles())
        orderTwo.addItem(Vegetables())
        ordersList.add(orderTwo)

        // Add list of items at one time
        val orderThree = Order(3)
        val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
        orderThree.addAll(items)
        ordersList.add(orderThree)

        // Use builder pattern
        val orderFour = Order(4)
            .addItem(Noodles())
            .addItem(Vegetables("Tomato", "Potato"))
        ordersList.add(orderFour)

        // Create and add order
        ordersList.add(
            Order(5)
                .addItem(Noodles())
                .addItem(Noodles())
                .addItem(Vegetables("Carrot"))
        )

        for (order in ordersList) {
            order.print()
            println()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()
    }
}
