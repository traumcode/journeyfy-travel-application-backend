package com.journeyfy.journeyfytravelapplication.clubs;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "museums")
public class ClubController {
    @GetMapping
    public List<ClubModel> getAllClubs() {
        return Arrays.asList(
                new ClubModel(1L,
                        "Berghain",
                        " Am Wriezener Bahnhof, 10243 Berlin, Germany",
                        "Berlin",
                        "Berghain (pronounced [bɛʁkhaɪn]) is a nightclub in Berlin, Germany. It is named after its location near the border between Kreuzberg and Friedrichshain in Berlin, and is a short walk from Berlin Ostbahnhof main line railway station.",
                        "https://www.atravelthing.com/wp-content/uploads/2018/04/The-Berghain-club-in-Berlin.jpg",
                        4.0
                        ),
                new ClubModel(2L,
                        "Tresor",
                        "Köpenicker Str. 70, 10179 Berlin, Germany",
                        "Berlin",
                        "Tresor (German for safe or vault) is an underground techno nightclub in Berlin and a record label.",
                        "https://static.dw.com/image/17368811_403.jpg",
                        4.3
                        ),
                new ClubModel(3L,
                        "Hoppetosse",
                        "Eichenstraße 4, 12435 Berlin, Germany",
                        "Berlin",
                        "Hoppetosse is the on-water sister venue to the well-known Club der Visionäre. It's a permanently docked boat (dubbed MS Hoppetosse), located on the Spree not far from Arena Club. There's usually one dance floor—surrounded by crystal-clear Morf speakers from Mo Stern—in action at parties, which usually take place on the weekends. Like its smaller neighbour, Hoppetosse's booking policy focusses on minimalist house and techno, delivered by a combination of local favourites and a rotating cast of the style's key names.",
                        "https://imgproxy.ra.co/_/quality:100/plain//images/clubs/lg/de-hoppetosse-berlin.jpg",
                        4.0
                ),
                new ClubModel(4L,
                        "Jahrhunderthalle",
                        "Pfaffenwiese 301, 65929 Frankfurt am Main, Germany",
                        "Frankfurt",
                        "No description yet.",
                        "https://www.jahrhunderthalle.de/media/668306/_dsc7902_kleiner.jpg",
                        3.6
                ),
                new ClubModel(5L,
                        "Musiklokal Südbahnhof",
                        "Hedderichstraße 51, 60594 Frankfurt am Main, Germany",
                        "Frankfurt",
                        "No description yet.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/95/cb/eb/musiklokal-sudbahnhof.jpg?w=120",
                        4.0
                ),
                new ClubModel(6L,
                        "Nacht Leben",
                        "Kurt-Schumacher-Straße 45, 60313 Frankfurt am Main, Germany",
                        "Frankfurt",
                        "No description yet.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/ac/97/23/nachtleben.jpg?w=1200&h=-1&s=1",
                        4.0
                ),
                new ClubModel(7L,
                        "Moog",
                        "Carrer de l'Arc del Teatre, 3, 08002 Barcelona, Spain",
                        "Barcelona",
                        "Happening hangout for techno music, live concerts & dancing, as well as cocktails.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/6a/3f/68/photo0jpg.jpg?w=1100&h=-1&s=1",
                        3.5
                ),
                new ClubModel(8L,
                        "The Warehouse",
                        "secret",
                        "Barcelona",
                        "Compact nightclub known for electro beats, art exhibits & a relaxed atmosphere.",
                        "https://sonar.es/system/attached_images/7058/medium/showcase-the-warehouse.jpg?1464693257",
                        3.5
                ),
                new ClubModel(9L,
                        "Mya Club",
                        "Av. del Professor López Piñero, 5, 46013 València, Valencia, Spain",
                        "Valencia",
                        "Compact nightclub known for electro beats, art exhibits & a relaxed atmosphere.",
                        "https://www.lynxproaudio.com/www/home/lx-resources/uploads/2018/05/Slider-MYA2-1080x675.jpg",
                        4.6
                ),
                new ClubModel(10L,
                        "Raspoutin Paris",
                        "58 Rue de Bassano, 75008 Paris, France",
                        "Paris",
                        "No description availablee.",
                        "https://raspoutine.com/wp-content/uploads/2015/03/Raspoutine-Paris01e-2000x1000.jpg",
                        3.6
                ),
                new ClubModel(11L,
                        "L'Arc Paris",
                        "12 Rue de Presbourg, 75116 Paris, France",
                        "Paris",
                        "Compact nightclub known for electro beats, art exhibits & a relaxed atmosphere.",
                        "https://clubbable.blob.core.windows.net/medias/L'Arc-Paris-1",
                        4.3
                ),
                new ClubModel(12L,
                        "Terminal",
                        "3 Rue Terme, 69001 Lyon, France",
                        "Lyon",
                        "Compact nightclub known for electro beats, art exhibits & a relaxed atmosphere.",
                        "https://scontent.fotp3-3.fna.fbcdn.net/v/t1.6435-9/159744730_1855334857962481_2165560740453939570_n.jpg?_nc_cat=101&ccb=1-4&_nc_sid=730e14&_nc_ohc=z1qmE57ZHfEAX8b6TmL&_nc_ht=scontent.fotp3-3.fna&oh=94c903dbbb1fb5de75df9f7f268c07ee&oe=61374984",
                        4.6
                ),
                new ClubModel(13L,
                        "Axar",
                        "52 Quai Rambaud, 69002 Lyon, France",
                        "Lyon",
                        "No description",
                        "https://www.lynxproaudio.com/www/home/lx-resources/uploads/2018/05/Slider-MYA2-1080x675.jpg",
                        5
                )
        );
    }
}
