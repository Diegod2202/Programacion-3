import requests

def get_top_50_coins(order_by='quoteVolume'):
    url = "https://api.binance.com/api/v3/ticker/24hr"
    response = requests.get(url)
    
    if response.status_code != 200:
        raise Exception("Error fetching data from Binance API")
    
    data = response.json()
    
    # Filtrar solo las monedas contra USDT (mercado principal)
    usdt_pairs = [coin for coin in data if coin['symbol'].endswith('USDT')]
    
    # Ordenar por el campo especificado en el parámetro order_by
    top_50 = sorted(usdt_pairs, key=lambda coin: float(coin[order_by]), reverse=True)[:50]
    
    coin_list = [(coin['symbol'], float(coin['lastPrice']), float(coin['priceChangePercent']), float(coin['quoteVolume'])) for coin in top_50]
    
    return coin_list

def QuickSort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[len(arr) // 2][1]
        left = [x for x in arr if x[1] > pivot]
        middle = [x for x in arr if x[1] == pivot]
        right = [x for x in arr if x[1] < pivot]
        return QuickSort(left) + middle + QuickSort(right)

def find_highest_gainer(coins):
    # Inicializar la variable para almacenar la moneda con mayor cambio porcentual
    highest_gainer = coins[0]
    
    # Recorrer la lista de monedas para encontrar la que tenga el mayor cambio porcentual
    for coin in coins:
        if coin[2] > highest_gainer[2]:
            highest_gainer = coin
    
    return highest_gainer

def find_optimal_coins(coins, value):
    # Inicializar la lista de monedas óptimas
    optimal_coins = []
    ordered_by_price = QuickSort(coins)
    
    remaining_value = float(value)
    total_spent = 0.0
    
    for coin in ordered_by_price:
        coin_price = coin[1]
        if coin_price <= remaining_value:
            max_quantity = remaining_value // coin_price
            optimal_coins.append((coin[0], max_quantity, coin_price))
            spent = max_quantity * coin_price
            total_spent += spent
            remaining_value -= spent
    
    return optimal_coins, total_spent

if __name__ == "__main__":
    # Imprimo la lista de las 50 monedas con mayor volumen de trading en las últimas 24 horas
    top_coins = get_top_50_coins()
    formatted_coins = "\n".join([f"{symbol}: Price: {price}, Volume: {volume}, Change: {change}%" for symbol, price, change, volume in top_coins])
    # print(formatted_coins + "\n")

    # Imprimo la lista de las 50 monedas ordenadas por precio de mayor a menor
    sorted_list = QuickSort(top_coins)
    formatted_coins = "\n".join([f"{symbol}: Price: {price}, Volume: {volume}, Change: {change}%" for symbol, price, change, volume in sorted_list])
    # print(formatted_coins + "\n")
    
    # Imprimo la moneda con mayor cambio porcentual en las últimas 24 horas
    highest_gainer = find_highest_gainer(top_coins)
    # print(f"Highest gainer in the last 24 hours: {highest_gainer[0]} with a change of {highest_gainer[2]}%")

    value = input("Introduce un valor: ")
    optimal_coins, total_spent = find_optimal_coins(top_coins, value)
    print(f"Optimal coins for a value of {value}:")
    for coin in optimal_coins:
        spent_per_coin = coin[1] * coin[2]
        print(f"Moneda: {coin[0]}, Cantidad: {coin[1]}, Precio por moneda: {coin[2]}, Gastado: {spent_per_coin}")
    print(f"Total gastado: {total_spent}")