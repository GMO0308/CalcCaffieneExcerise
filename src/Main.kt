/**
 * Function to calculate caffeine level based on hours worked, bugs found, and energy level.
 * This function uses sequence selection to determine the energy bonus and caffeine level.
 */
fun calculateCaffeineLevel(hoursWorked: Int, bugsFound: Int, energy: String = "tired"): String {
    // Sequence selection: Determine energy bonus based on the energy level; Lambda expression.
    // 'When' Expression used to replace Switch case.
    val energyBonus = when (energy) {
        "tired" -> 5
        "awake" -> 0
        "zombie" -> 10
        else -> 0
    }
    // Calculate the caffeine score
    // "5 hours + (2 bugs found x 2) + 5 = 14 Score *Strong"
    val score = hoursWorked + (bugsFound * 2) + energyBonus
    // Sequence selection: Return caffeine level (Range)
    // based on the score based on score falling less than or equal to the Value, from inclusivity.
    // Return When Condition;
    return when (score) {
        in 0..5 -> "light" // Between Awake
        in 6..10 -> "medium" // Between
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
    // '.all' takes Predict as an argument;
    // (function literals) taking an element of collection as input and returns Boolean value.
    // Trailing Lambda Expression is automatic.
    return orderItems.all { item -> item in availableIngredients }
}

/**
 * Function to create a drink name with a base type and optional modifiers.
 * This function uses iteration to fold the modifiers into a single string.
 */
fun createDrinkName(baseType: String, vararg modifiers: String): String {
    // Iteration: Use fold to build the drink name string with modifiers
    // vararg modifier receives 0 or More arguments of String
    // '.fold' combines multiple modifiers into a single Modifier.
    // acc (accumulator) represents accumulated value during the iteration
    return modifiers.fold("The $baseType") { acc, modifier -> "$acc with extra $modifier" }
}

/**
 * Main function to test the other functions.
 * This function demonstrates the use of the other functions.
 */
// Test your coffee shop management skills!
fun main() {
    println("☕ WELCOME TO COFFEE & CODE! ☕")
    println("Serving caffeinated programmers since 2025\n")

    // Test calculateCaffeineLevel
    println("Dev worked 5 hours, found 2 bugs, feeling tired:")
    println("☕ Recommended: ${calculateCaffeineLevel(5, 2, "tired")}")

    // Test canFulfillOrder
    val available = listOf("coffee", "milk", "sugar", "vanilla", "wifi")
    val order = listOf("coffee", "milk", "wifi")
    println("\n📦 Can fulfill order $order? ${canFulfillOrder(order, available)}")

    // Test createDrinkName
    println("\n🍺 New drink: '${createDrinkName("NullPointer", "caffeine", "desperation", "prayers")}'")
}
