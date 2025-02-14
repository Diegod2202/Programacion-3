import requests

def get_top_coins(quantity):
    url = "https://api.binance.com/api/v3/ticker/24hr"
    response = requests.get(url)
    
    if response.status_code != 200:
        raise Exception("Error fetching data from Binance API")
    order_by='quoteVolume'
    data = response.json()
    
    # Filtrar solo las monedas contra USDT (mercado principal)
    usdt_pairs = [coin for coin in data if coin['symbol'].endswith('USDT')]
    
    # Ordenar por el campo especificado en el parámetro order_by
    top_n = sorted(usdt_pairs, key=lambda coin: float(coin[order_by]), reverse=True)[:quantity]
    
    coin_list = [(coin['symbol'], float(coin['lastPrice']), float(coin['priceChangePercent']), float(coin['quoteVolume'])) for coin in top_n]
    
    return coin_list

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[len(arr) // 2][1]
        left = [x for x in arr if x[1] > pivot]
        middle = [x for x in arr if x[1] == pivot]
        right = [x for x in arr if x[1] < pivot]
        return quick_sort(left) + middle + quick_sort(right)

def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    left = merge_sort(left)
    right = merge_sort(right)

    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i][1] > right[j][1]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result

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
    quantity = int(input("Introduzca la cantidad de monedas que desea ver: "))
    print(f"Impresión de la lista de las {quantity} monedas con mayor volumen de trading en las últimas 24 horas: ")
    print()
    top_coins = get_top_coins(quantity)
    formatted_coins = "\n".join([f"{symbol}: Price: {price}, Volume: {volume}, Change: {change}%" for symbol, price, change, volume in top_coins])
    print(formatted_coins + "\n")
    print("---------------------------------")

    # Imprimo la lista de las 50 monedas ordenadas por precio de mayor a menor por quick
    print("Impresion de la lista de las monedas ordenadas por precio de mayor a menor usando quick sort:" )
    print()
    sorted_list = quick_sort(top_coins)
    formatted_coins = "\n".join([f"{symbol}: Price: {price}, Volume: {volume}, Change: {change}%" for symbol, price, change, volume in sorted_list])
    print(formatted_coins + "\n")
    print("---------------------------------")

    # Imprimo la lista de las monedas ordenadas por precio de mayor a menos por merge sort
    print("Impresion de la lista de las monedas ordenadas por precio de mayor a menor usando merge sort:" )
    print()
    sorted_list_merge = merge_sort(top_coins)
    formatted_coins = "\n".join([f"{symbol}: Price: {price}, Volume: {volume}, Change: {change}%" for symbol, price, change, volume in sorted_list_merge])
    print(formatted_coins + "\n")
    print("---------------------------------")
    print()
    # Imprimo la moneda con mayor cambio porcentual en las últimas 24 horas
    highest_gainer = find_highest_gainer(top_coins)
    print(f"La moneda con mayor subida porcentual en las últimas 24hrs es {highest_gainer[0]} con un cambio de {highest_gainer[2]}%")
    print("---------------------------------")
    print()
    # Imprimo la cantidad de monedas óptimas para rellenar un valor en dólares   
    value = input("Introduzca un valor en dólares para saber la cantidad de monedas que se pueden adquirir: ")
    print()
    optimal_coins, total_spent = find_optimal_coins(top_coins, value)
    print(f"Monedas óptimas para rellenar {value} dólares:")
    print()
    for coin in optimal_coins:
        spent_per_coin = coin[1] * coin[2]
        print(f"Moneda: {coin[0]}, Cantidad: {coin[1]}, Precio por moneda: {coin[2]}, Gastado: {spent_per_coin}")
    print()
    print(f"Total gastado: $ {total_spent}")