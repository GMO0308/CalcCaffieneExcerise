/**
 * Function to calculate caffeine level based on hours worked, bugs found, and energy level.
 * This function uses sequence selection to determine the energy bonus and caffeine level.
 */
fun calculateCaffeineLevel(hoursWorked: Int, bugsFound: Int, energy: String = "tired"): String {
    // Sequence selection: Determine energy bonus based on the energy level
    val energyBonus = when (energy) {
        "tired" -> 5
        "awake" -> 0
        "zombie" -> 10
        else -> 0
    }
    // Calculate the caffeine score
    val score = hoursWorked + (bugsFound * 2) + energyBonus
    // Sequence selection: Return caffeine level based on the score
    return when (score) {
        in 0..5 -> "light"
        in 6..10 -> "medium"
        in 11..15 -> "strong"
        else -> "rocket fuel"
    }
}

/**
 * Function to check if an order can be fulfilled with available ingredients.
 * This function uses iteration to check each item in the order.
 */
fun canFulfillOrder(orderItems: List<String>, availableIngredients: List<String>): Boolean {
    // Iteration: Check if all order items are available in the ingredients list
    return orderItems.all { item -> item in availableIngredients }
}

/**
 * Function to create a drink name with a base type and optional modifiers.
 * This function uses iteration to fold the modifiers into a single string.
 */
fun createDrinkName(baseType: String, vararg modifiers: String): String {
    // Iteration: Use fold to build the drink name string with modifiers
    return modifiers.fold("The $baseType") { acc, modifier -> "$acc with extra $modifier" }
}

/**
 * Main function to test the other functions.
 * This function demonstrates the use of the other functions.
 */
fun main() {
    println("** WELCOME TO COFFEE & CODE! **")
    println("Serving caffeinated programmers since 2025\n")

    // Test calculateCaffeineLevel function
    println("Dev worked 12 hours, found 8 bugs, feeling zombie:")
    println("** Recommended: ${calculateCaffeineLevel(12, 8, "zombie")}")

    // Test canFulfillOrder function
    val available = listOf("coffee", "milk", "sugar", "vanilla", "wifi")
    val order = listOf("coffee", "milk", "wifi")
    println("\n** Can fulfill order $order? ${canFulfillOrder(order, available)}")

    // Test createDrinkName function
    println("\n** New drink: '${createDrinkName("NullPointer", "caffeine", "desperation", "prayers")}'")
}
