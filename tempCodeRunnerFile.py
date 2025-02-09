def find_optimal_coins(coins, value):
    # Inicializar la lista de monedas óptimas
    optimal_coins = []
    ordered_by_price = QuickSort(coins)

    for coin in ordered_by_price:
        if coin[1] <= float(value):
            optimal_coins.append(coin)
        else:
            break

    return optimal_coins
