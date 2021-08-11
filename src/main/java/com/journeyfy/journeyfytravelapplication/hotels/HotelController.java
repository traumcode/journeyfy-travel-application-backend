package com.journeyfy.journeyfytravelapplication.hotels;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "hotels", produces = "application/json")
public class HotelController {

    public static List<HotelModel> hotels = Arrays.asList(
            new HotelModel(1L,
                    "Le Tsuba Hotel",
                    4,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/3a/f9/01/le-tsuba-hotel.jpg?w=1200&h=-1&s=1",
                    "Everyone needs a place to lay their weary head. For travelers visiting Paris, Le Tsuba Hotel is an excellent choice for rest and rejuvenation. Well-known for its romantic environment and proximity to great restaurants and attractions, Le Tsuba Hotel makes it easy to enjoy the best of Paris. Guest rooms offer amenities such as a flat screen TV, air conditioning, and a minibar, and guests can go online with free wifi offered by the hotel. Le Tsuba Hotel features a concierge and room service, to help make your stay more enjoyable. The property also boasts a wellness area with Sauna, Hammam and gym, and breakfast. Nearby landmarks such as Eiffel Tower (1.3 mi) and Palais Garnier - Opéra National de Paris (1.8 mi) make Le Tsuba Hotel a great place to stay when visiting Paris. Travelers looking to enjoy some shrimp can head to L'Avenue, L'Avant Comptoir, or Pedra Alta. Otherwise, you may want to check out a steakhouse such as Le Relais de l'Entrecote, La Poule au Pot, or Sacrée fleur. If you are interested in exploring Paris, check out one of the ancient ruins, such as Archeological Crypt of the Parvis of Notre-Dame, Arenes de Lutece, and Les vestiges des Tuileries. Whether you’re traveling for business, pleasure or both, Le Tsuba Hotel is sure to make your visit to Paris one worth remembering.",
                    777,
                    4.5,
                    "Paris",
                    "https://www.tripadvisor.com/Hotel_Review-g187147-d10521834-Reviews-Le_Tsuba_Hotel-Paris_Ile_de_France.html"),
            new HotelModel(2L,
                    "Hotel la Nouvelle Republique",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/4a/e7/60/chambre-triple.jpg?w=1200&h=-1&s=1",
                    "Hotel La Nouvelle République is a boutique hôtel located in the 11th district. The hotel La Nouvelle République welcomes you just few minutes away from metro lines 2, 3 and 11 as well as bus 96 which will take you directly to Rive Gauche. The property is at 5 minutes bike ride from Place de la République, if you just walk down Rue Oberkampf you can reach the Marais within 15 minutes. Decorated in a vintage quirky style, the soundproofed and air-conditioned rooms gives you the opportunity to relax fully. The hotel features mostly king size beds with all confort such as hairdryer, thick mattress, usb plugs, safe, tablet in rooms, tv screen. The hotel La Nouvelle République invites you every morning for a Free buffet breakfast. In addition, free drinks (tea, coffee, bottled water) are available throughout the day in our lobby. Finally, you can enjoy the excitement of this area where there are many exiting bars and restaurants. The 11th arrondissement is one of the most the creative scene of Paris. C'est le vrai Paris!",
                    826,
                    5.0,
                    "Paris",
                    "https://www.tripadvisor.com/Hotel_Review-g187147-d12829774-Reviews-Hotel_la_Nouvelle_Republique-Paris_Ile_de_France.html"),
            new HotelModel(3L,
                    "InterContinental Paris - Le Grand",
                    4,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/28/bd/f7/view-from-property.jpg?w=1200&h=-1&s=1",
                    "The InterContinental Paris Le Grand, opened during the reign of Napoleon III, is located in the very heart of the city: across the street from the Opéra Garnier, close to some of the best-known Parisian attractions, world-famous department stores and the wonderful Place Vendôme. The hotel contains 470 rooms, all richly decorated in the colours of the Opéra, and a warmly illuminated haven of peace and serenity in the bustle of Parisian life: la Verrière.",
                    1.568,
                    4.5,
                    "Paris",
                    "https://www.tripadvisor.com/Hotel_Review-g187147-d207742-Reviews-InterContinental_Paris_Le_Grand-Paris_Ile_de_France.html"),
            new HotelModel(4L,
                    "Hotel La Manufacture",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/f2/0a/f3/chambre-eiffel.jpg?w=900&h=-1&s=1",
                    "Housed in a charming 19th century building, La Manufacture is an elegant establishment, decorated with taste and style and blending the past with the present. The use of soft, natural colors and the careful attention to detail reflects perfectly the inviting atmosphere to be found. Oak floorboards, wicker chairs, cotton rugs, wooden furniture make this charming Boutique Hotel a real feast for the eyes.",
                    469,
                    4.5,
                    "Paris",
                    "https://www.tripadvisor.com/Hotel_Review-g187147-d197563-Reviews-Hotel_La_Manufacture-Paris_Ile_de_France.html"),
            new HotelModel(5L,
                    "Grand Hotel du Palais Royal",
                    5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/0f/c2/71/junior-suite.jpg?w=1200&h=-1&s=1",
                    "Ideally located between the Louvre Museum and the Opera house, opposite the Palais Royal gardens, this 5 star hotel, a refined cocoon beautifully decorated by the renowned Pierre-Yves Rochon, is a must-visit address in the heart of Paris. Behind its majestic facade listed as a historical monument, the hotel counts 68 rooms and suites, some with spectacular views of Paris, a restaurant, a bar (after work, tea time), a meeting room, a fitness center with Turkish bath and a Spa with a double cabin.",
                    1.829,
                    5.0,
                    "Paris",
                    "https://www.tripadvisor.com/Hotel_Review-g187147-d617625-Reviews-Grand_Hotel_du_Palais_Royal-Paris_Ile_de_France.html"),
            new HotelModel(1L,
                    "Hotel Carlton Lyon - MGallery Collection",
                    4,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/e1/a7/08/view-from-our-room.jpg?w=1200&h=-1&s=1",
                    "Be enchanted by the Carlton Lyon hotel, " +
                            "located on the peninsula. Despite being fully renovated in 2013, it has retained its authenticity " +
                            "and personality, blending contemporary comfort with sophistication. Relax in one of the 80 tastefully decorated" +
                            " rooms or in the cozy atmosphere of the bar. The hotel is just a 5-minute walk from the Bellecour metro stop " +
                            "and is the ideal base for exploring Lyon, with its opera house, museums, the St. Jean cathedral and more. " +
                            "Located between the Rhone and Saone rivers, the Carlton Lyon hotel was built in 1894 as a \"petit palace\" " +
                            "in Lyon. Punctuated by its forged iron balconies, dome and rotundas, its splendid Haussmann facade echoes the " +
                            "refinement of its historical decor. The hotel's \"Signature\" rooms also highlight artists who have stayed there." +
                            " Travelers will appreciate immersing themselves in the splendid adornments of the many talents that have visited the hotel.",
                    697,
                    4.5,
                    "Lyon",
                    "https://www.tripadvisor.com/Hotel_Review-g187265-d232355-Reviews-Hotel_Carlton_Lyon_MGallery_Collection-Lyon_Rhone_Auvergne_Rhone_Alpes.html"),
            new HotelModel(2L,
                    "Hotelo, l'hotel au coeur de Lyon",
                    2,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/6d/c4/e4/imag4061-largejpg.jpg?w=800&h=-1&s=1",
                    "The Hotelo hotel is ideally situated (close to Perrache and Ampère metro stations) in the very heart of Lyon, a designated UNESCO World Heritage site. The hotel is only a stone's throw from Perrache train station, with both Place Carnot and Place Bellecour on the doorstep. The districts of Gerland and La Confluence are easily accessible, as are the Jean Moulin, Lyon 2 and Catholic Universities. The Hotelo hotel is an ideal base for you to visit the town and surrounding areas, from Vieux Lyon to the more modern quarter of La Confluence. Plus it's easy to get around without your car with the metro, bus, tramway and Vélo'V bicycle hire all within easy reach. A perfect way to visit our beautiful city of Lyon! The hotel is entirely non-smoking. All rooms are en-suite with either a shower or a bath and are equipped with flat-screen TV, telephone and free Wifi access. Our friendly team is on hand to personally welcome you to the Hotelo Hotel.",
                    398,
                    4.5,
                    "Lyon",
                    "https://www.tripadvisor.com/Hotel_Review-g187265-d1377912-Reviews-Hotelo_l_hotel_au_coeur_de_Lyon-Lyon_Rhone_Auvergne_Rhone_Alpes.html"),
            new HotelModel(3L,
                    "Boscolo Lyon Hotel & Spa",
                    5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/59/a1/54/fredericdurantet.jpg?w=1200&h=-1&s=1",
                    "In a splendid setting between the Rhone and the Saone, in the most prestigious district of Lyon, a few steps from Place Bellecour and the Grand Hotel-Dieu, a majestic 19th century building, expertly renovated, is intended to become one of the most luxurious 5 stars hotel of Lyon. Let yourself be enchanted by the view from your room overlooking the Rhone or relax, while tasting a “ristretto coffee” in the luxurious Grand Salon, created in the former winter garden surmounted by a panoramic glass roof. The peculiarity of the Luxury Hotel Boscolo Lyon consists in the delicate balance between the splendor of the Haussmann’ architecture and the loveliness of the atmospheres created by the black marble, Vicenza stone, sophisticated curtains and other precious materials. Once acquired the hotel in 2002, Angelo Boscolo undertakes its metamorphosis at the end of 2018. The doors of the new Boscolo Lyon open.",
                    1.051,
                    4.5,
                    "Lyon",
                    "https://www.tripadvisor.com/Hotel_Review-g187265-d15111966-Reviews-Boscolo_Lyon_Hotel_Spa-Lyon_Rhone_Auvergne_Rhone_Alpes.html"),
            new HotelModel(1L,
                    "H10 Madison",
                    4.5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/41/96/56/h10-madison.jpg?w=1200&h=-1&s=1",
                    "Located in the heart of Barcelona, just 240 metres from the cathedral, the H10 Madison is a new four-star superior hotel. The hotel features elegant rooms, a full range of dining options with restaurant and Lobby Bar, two meeting rooms and an amazing terrace with plunge pool and close-up views of the cathedral.",
                    715,
                    5.0,
                    "Barcelona",
                    "https://www.tripadvisor.com/Hotel_Review-g187497-d13223478-Reviews-H10_Madison-Barcelona_Catalonia.html"),
            new HotelModel(2L,
                    "Serras",
                    5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/66/69/4e/rooftop-the-serras.jpg?w=1200&h=-1&s=1",
                    "This luxury boutique hotel comprises 28 trendy and very spacious rooms and suites, a Michelin star Chef Restaurant and a chill out rooftop terrace. This elegant 5-star boutique hotel overlooking the new luxury Port Vell alongside the Mediterranean Sea, offers a unique hideaway with a modern understated decor. Ideal for your weekend breaks, business trips and luxury holidays in the heart of Barcelona. It boasts a cool, trendy atmosphere, world class amenities and dedicated personal service for a truly memorable hotel experience in the first studio of Pablo Picasso on vibrant Barrio Gotico. Restaurant Informal Our Michelin Star Chef invites you to experience his Catalan specialties in a delicious selection of Mediterranean tapas, prepared from fresh seasonal ingredients sourced from our local market. Rooftop Terrace Offering breathtaking views of the Mediterranean Sea and the new Marina of Port Vell, our stylish rooftop terrace comes beautifully appointed with a superb infinity pool and comfortable lounge area.",
                    1.139,
                    5.0,
                    "Barcelona",
                    "https://www.tripadvisor.com/Hotel_Review-g187497-d7142609-Reviews-Serras-Barcelona_Catalonia.html"),
            new HotelModel(3L,
                    "Hotel Jazz",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/88/db/08/hotel-jazz-pool.jpg?w=1200&h=-1&s=1",
                    "An unbeatable location in the heart of Barcelona, between Plaza Catalunya, Paseo de Gracia, and the famous Ramblas, has made Hotel Jazz into one of the city’s most cosmopolitan hotels and grant guests easy access to the city’s historical attractions and Gaudí’s modernist architecture throughout the neighborhood of the Eixample.. A magnificent outdoor pool and a spacious terrace with a wide variety of tapas, wines and cocktails make the hotel a unique and spectacular spot for relaxing in the city center.",
                    536,
                    4.5,
                    "Barcelona",
                    "https://www.tripadvisor.com/Hotel_Review-g187497-d296916-Reviews-Hotel_Jazz-Barcelona_Catalonia.html"),
            new HotelModel(1L,
                    "Hotel Malcom and Barret",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/5b/94/b3/hotel-malcom-and-barret.jpg?w=1200&h=-1&s=1",
                    "The hotel Malcom & Barret is located 5 minutes from the City of Arts and Sciences. It has 168 comfortable single, double and triple rooms, equipped with air conditioning hot/cold, free wifi, 40 'Led TV with international channels, safe, magnifying mirror, desk, bathroom with shower, hairdryer and amenities . Visit our children's room where they will have a great time. Board games, stories to read, books to paint, a great blackboard to release all their creativity and a play station for the most followers of video games. The hotel Malcom & Barret offers a restaurant service with buffet breakfast, lunch and dinner a la carte, a gin bar for a drink after a day of work or sightseeing. It also offers rooms for meetings or events, a 24-hour reception service and luggage storage. The location of the hotel makes it an ideal starting point for visiting both the city center and the beach or the area of the Congress Palace. Parking is not recommended for vehicles over 4.5 mtrs.",
                    358,
                    4.5,
                    "Valencia",
                    "https://www.tripadvisor.com/Hotel_Review-g187529-d206949-Reviews-Hotel_Malcom_and_Barret-Valencia_Province_of_Valencia_Valencian_Country.html"),
            new HotelModel(2L,
                    "Vincci Palace",
                    4,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/56/ac/3a/habitacion-superior.jpg?w=1200&h=-1&s=1",
                    "In the most select district in the centre of the Turia’s capital, we find the Vincci Palace Valencia.\uFEFF Located on calle de La Paz, two steps away from the Plaza Porta de la Mar and Paseo de la Ciudadela, it is in the city’s great tourist area, five minutes away from the Cathedral and the Church of Nuestra Señora de los Desamparados (Our Lady of the Forsaken), also right next door to the Serranos towers and the famous “Miguelete”. The building, in the traditional style of most palace residences in the city centre, has been totally refurbished to maintain its impressive façade while remodelling its interior to make it one of the capital’s most contemporary hotel establishments.",
                    590,
                    4.0,
                    "Valencia",
                    "https://www.tripadvisor.com/Hotel_Review-g187529-d652524-Reviews-Vincci_Palace-Valencia_Province_of_Valencia_Valencian_Country.html"),
            new HotelModel(3L,
                    "Valencia Center Hotel",
                    4,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/df/18/e4/608670-pool.jpg?w=600&h=-1&s=1",
                    "Rooms at Valencia Hotel provide a flat screen TV, air conditioning, and a minibar, and guests can stay connected with free wifi.\n" +
                            "\n" +
                            "In addition, while staying at Valencia Hotel guests have access to a 24 hour front desk, room service, and a rooftop terrace. You can also enjoy a rooftop pool and a lounge. Need a place to park? Parking is available at Valencia Center Hotel.\n" +
                            "\n" +
                            "Nearby landmarks such as Plaza de Toros de Valencia (1.5 mi) and Palacio del Marques de Dos Aguas (1.6 mi) make Valencia Hotel a great place to stay when visiting Valencia.\n" +
                            "\n" +
                            "During your visit, be sure to check out one of Valencia's popular ramen restaurants such as Kamon, Ramen Kuma, and Ryukishin Valencia, all a short distance from Valencia Hotel.\n" +
                            "\n" +
                            "Best of all, Valencia Center Hotel makes it easy to experience many great Valencia attractions like Valencia Cathedral, La Lonja de la Seda, and Trinquet de Pelayo (Recinto Deportivo), which are some popular historic sites.\n" +
                            "\n" +
                            "We’re sure you’ll enjoy your stay at Valencia Center Hotel as you experience everything Valencia has to offer.",
                    399,
                    4.0,
                    "Valencia",
                    "https://www.tripadvisor.com/Hotel_Review-g187529-d543230-Reviews-Valencia_Center_Hotel-Valencia_Province_of_Valencia_Valencian_Country.html"),
            new HotelModel(1L,
                    "Radisson Blu Hotel",
                    4.5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/6a/af/33/nikolai-suite-living.jpg?w=1100&h=-1&s=1",
                    "The Radisson Blu Hotel is one of the most exciting hotels in Berlin-Mitte. It is located in the historic centre directly on the bank of the river Spree and opposite to the Berlin Cathedral. Just a strolls away are restaurants, bars, boutiques, galleries and famous sights, such as Alexanderplatz, Museum Island, Boulevard Unter den Linden and the exclusive shops along Friedrichstrasse. Public transport, Berlin airport and the Messe Berlin fairground are within easy reach. A unique attraction is the AquaDom at the hotel lobby. It is the world’s largest cylindrical aquarium with a fascinating underwater world in one million litres of salt-water. 427 non-smoking guest rooms and suites combine timeless elegance with cutting edge comfort. The clear design in the puristic style reflects urban trends. The dark wood and warm tones of the high-class furniture create a homely atmosphere. All rooms are equipped with flat screen TV, trouser press, laptop-size safe, air-conditioning, minibar, tea and coffee provisions. Wireless-LAN and high-speed Internet access is included in the room rate.",
                    1.153,
                    4.5,
                    "Berlin",
                    "https://www.tripadvisor.com/Hotel_Review-g187323-d202459-Reviews-Radisson_Blu_Hotel_Berlin-Berlin.html"),
            new HotelModel(2L,
                    "Regent Berlin",
                    5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/00/52/86/hotel-lobby.jpg?w=1200&h=-1&s=1",
                    "For travelers visiting Berlin, Regent Berlin is an excellent choice for rest and rejuvenation. Well-known for its luxury environment and proximity to great restaurants and attractions, Regent Berlin makes it easy to enjoy the best of Berlin. In 2020 the hotel was awarded as \"Germany´s Leading Hotel\" by the World Travel Awards. Regent Berlin is a luxury hotel offering a flat screen TV and a minibar in the rooms, and it is easy to stay connected during your stay as free Wi-Fi is offered to guests. The hotel features a concierge and room service. Plus, guests can enjoy a fitness center and a Tea Lounge, which have made this a popular choice among travelers visiting Berlin. Given the close proximity of popular landmarks, such as German Historical Museum (0.3 mi) and Museum Island (0.5 mi), guests of Berlin Regent can easily experience some of Berlin's most well known attractions. While you’re here, be sure to check out some of the seafood restaurants, including KaDeWe Feinschmeckerbars, Ristorante Pizzeria Sapori di Casa, and Pisco Perú, all of which are a short distance from the Regent Berlin Hotel. If you’re looking for something to do, Berlin Humboldtforum (0.5 mi), Reichstag Building (0.7 mi), and Pergamonmuseum (0.5 mi) are a nice way to spend some time, and they are all within walking distance of Regent Berlin. Whether you’re traveling for business, pleasure or both, Regent Berlin is sure to make your visit to Berlin one worth remembering.",
                    1.065,
                    4.5,
                    "Berlin",
                    "https://www.tripadvisor.com/Hotel_Review-g187323-d190664-Reviews-Regent_Berlin-Berlin.html"),
            new HotelModel(3L,
                    "Hotel AMANO Grand Central",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/09/e8/1a/hotel-amano-grand-central.jpg?w=1200&h=-1&s=1",
                    "The AMANO Grand Central is the largest hotel the AMANO Group has built to date. Whether its business travel or a short city visit - it focuses on perfection in all areas: the AMANO Grand Central focuses on perfection in all areas: conference rooms suffused with light and equipped with modern technology, a fitness center with a view of the government district, the premium location and the gastronomic concept leave nothing to be desired. Whether you are looking for a light snack or a business lunch: the ground floor BISTRO serves city visitors or Berlin folk with the finest culinary dishes. After a long day of meetings or a day of exploring the city, the APARTMENT Bar with its spacious and green rooftop terrace is the ideal place to relax and unwind. Here too, the creators of the renowned AMANO Bar put great emphasis on a creative and quality bar culture that enriches the city's nightlife.",
                    328,
                    4.0,
                    "Berlin",
                    "https://www.tripadvisor.com/Hotel_Review-g187323-d8409027-Reviews-Hotel_AMANO_Grand_Central-Berlin.html"),
            new HotelModel(1L,
                    "Hotel City Residence",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/02/cb/a7/hotel-city-residence.jpg?w=1200&h=-1&s=1",
                    "Welcome to the City Residence Hotel Frankfurt-Oder The City Residence Hotel Frankfurt-Oder is centrally located, near the Central Train Station of Frankfurt-Oder, there are only a few steps from the city center and the historic old town. The City Residence Hotel Frankfurt-Oder is an ideal starting point for visiting the city and in the surrounding area.For Hotel guests of the City Residence Hotel Frankfurt-Oder, parking is for free . Guests of our Hotel in Frankfurt-Oder can use the wireless Internet for free in all rooms and public areas of the hotel. The City Residence Hotel Frankfurt Oder offers 43 comfortable furnished rooms.",
                    317,
                    4.0,
                    "Frankfurt",
                    "https://www.tripadvisor.com/Hotel_Review-g635854-d1724878-Reviews-Hotel_City_Residence-Frankfurt_Oder_Brandenburg.html"),
            new HotelModel(2L,
                    "Living Hotel Weissensee",
                    3,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/94/f8/6e/double-deluxe-duplex--v15239539.jpg?w=1200&h=-1&s=1",
                    "The Living Hotel Weissensee is your tranquil oasis in Berlin. Live away from the hustle and bustle of the capital and hold your meetings outdoors. Enjoy our comfortable rooms and Serviced Apartments, located right by Weissensee lake with its beach bar and sandy beach as well as plenty of fresh air in the city park. And if you do feel like heading into town, it only takes 15 minutes to reach Alexanderplatz.",
                    313,
                    4.5,
                    "Frankfurt",
                    "https://www.tripadvisor.com/Hotel_Review-g187323-d202461-Reviews-Living_Hotel_Weissensee_by_Derag-Berlin.html"),
            new HotelModel(3L,
                    "Seehotel Luisenhof",
                    3.5,
                    "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/07/1d/6e/3f/seehotel-luisenhof.jpg?w=900&h=-1&s=1",
                    "On the shores of Lake Gabelsee, this 3-star-Superior hotel features bright rooms with views of the surrounding Brandenburg countryside. It is less than a 15-minute walk from the centre of Falkenhagen.",
                    781,
                    3.0,
                    "Frankfurt",
                    "https://www.tripadvisor.com/Hotel_Review-g1183539-d1189760-Reviews-Seehotel_Luisenhof-Falkenhagen_Brandenburg.html")
    );

    @GetMapping(value = "/{cityName}")
    public List<HotelModel> getAllHotels(@PathVariable("cityName") String cityName) {
        return hotels.stream().filter(hotel -> hotel.getCityName().equals(cityName)).collect(Collectors.toList());
    }

    @GetMapping(value = "/top-hotels")
    public List<HotelModel> getTopHotels() {
        return hotels.stream().filter(hotel -> hotel.getRating() > 4.4).collect(Collectors.toList());
    }
}

