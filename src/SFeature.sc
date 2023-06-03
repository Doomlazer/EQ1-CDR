;;; Sierra Script 1.0 - (do not remove this comment)
(script# 120)
(include sci.sh)
(use Main)
(use EcoRoom)
(use Garbage)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm120 0
	trident 1
	TridentStatue 2
)

(local
	local0
	local1
	local2
	[local3 17] = [181 38 181 73 171 73 171 48 131 48 131 73 125 73 125 38]
	local20
	local21
	[local22 18] = [-1 -1 -16 106 14 16 106 108 135 360 156 4096 8 360 143 -15 157 -32768]
	[local40 12] = [-1 0 0 26 3 -16 26 25 19 340 22 16384]
	[local52 20] = [-1 1 240 34 1 -30 63 -21 63 67 77 8192 -1 106 77 251 119 240 34 -32768]
)
(procedure (localproc_0132 param1 param2)
	(= local0 param1)
	(= local1 param2)
)

(class SFeature of EcoFeature
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		lookStr 0
		newRoom 0
		decend 0
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: distantSwimmer 0 self)
			)
			(6 (EcoNarrator init: 3 0 0 88))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm120 of EcoRoom
	(properties
		picture 120
		style $8007
		horizon 15
		east 140
		south 100
		west 180
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(if
			(and
				(== gSouth 160)
				(gEgo has: 1)
				(not (proc819_5 5))
			)
			(proc958_0 128 831 150 121)
		else
			(eel init: stopUpd:)
		)
		(FishApartments init:)
		(CouncilChambers init:)
		(Gardens init:)
		(Urns init:)
		(TridentStatue init:)
		(MidStatue init:)
		(Temple init:)
		(Olympian init:)
		(oldColumns init:)
		(if (not (proc819_5 344))
			(gCast
				add: television cart chair beachBall pipe tricycle teddy radio
				eachElementDo: #init
			)
		)
		(if (== gSouth 100) (= style (= style 10)))
		(if (== ((Inv at: 20) owner?) 120)
			(trident posn: 217 44 init:)
		)
		(super init:)
		(if
			(and
				(proc819_5 6)
				(or
					(!= (gLongSong number?) 120)
					(== (gLongSong prevSignal?) -1)
				)
			)
			(gLongSong number: 120 loop: -1 play:)
		)
		(plant1 setCycle: Fwd init:)
		(plant2 init:)
		(plant3 init:)
		(if (not (proc819_5 61)) (bikeCage setPri: 3 init:))
		(councilPoly points: @local3 size: 8)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						173
						189
						173
						180
						262
						141
						252
						118
						252
						107
						314
						107
						314
						8
						6
						8
						6
						66
						0
						66
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 189 0 147 131 183 131 189
					yourself:
				)
				councilPoly
			setRegions: 51 50
		)
		(if (proc819_5 6) ((ScriptID 50 0) addFish: @local22))
		((ScriptID 50 0) addFish: @local52 @local40)
		(gEgo
			init:
			view: 802
			setLoop: gStopGroop
			illegalBits: 0
			setHeading: 180
			ignoreHorizon:
			setPri: 7
		)
		(if (and (gEgo has: 25) (not (proc819_5 73)))
			(proc819_7)
			(gDelph loop: 6 z: 0 init: posn: 124 139 setPri: 8)
		)
		(proc0_2)
		(switch gSouth
			(160
				(gEgo posn: 156 75)
				(if (and (gEgo has: 1) (not (proc819_3 5)))
					0
				else
					(localproc_0132 148 89)
				)
			)
			(140
				(gEgo posn: 300 60)
				(if (not (proc819_5 45))
					(localproc_0132 241 93)
				else
					(proc819_4 45)
				)
			)
			(180
				(gEgo posn: 0 120 setHeading: 90)
				(localproc_0132 40 120)
			)
			(200
				(gEgo posn: 44 21)
				(localproc_0132 100 100)
			)
			(else 
				(gEgo posn: 169 143 heading: 0 loop: 3)
				(if (proc819_5 6)
					(gEgo posn: 148 211)
					(localproc_0132 148 165)
				)
			)
		)
		(if local0
			(self
				setScript: enterScript 0 (proc999_5 gSouth 200 160 140)
			)
		else
			(switch gSouth
				(140
					(self setScript: (ScriptID 122 0))
				)
				(160
					(CouncilChambers approachVerbs: 0)
					((global2 obstacles?) delete: councilPoly)
					(= local2 1)
					(self setScript: (ScriptID 123 0))
				)
				(else 
					(if (not (proc819_3 6))
						(self setScript: (ScriptID 121 0))
					)
				)
			)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if (> global87 0) (Palette palANIMATE 33 43 7))
		(= temp0 (gEgo onControl: 1))
		(cond 
			((or script global115) 0)
			((and (& temp0 $4000) (not (proc819_5 7))) (self setScript: dontLeave))
			((and (& temp0 $0100) (not local2))
				(if
					(and
						(!= ((Inv at: 1) owner?) 160)
						(not (proc819_5 7))
					)
					(= local2 1)
					(self setScript: NoQuorum)
				else
					(self setScript: distantSwimmer 0 CouncilChambers)
				)
			)
			((& temp0 $0002) (self setScript: distantSwimmer 0 FishApartments))
			((& temp0 $0200) (self setScript: distantSwimmer 0 Temple))
			((== ((User alterEgo?) edgeHit?) 1) (self setScript: NoneEscortedEgo))
			((& temp0 $0008) (global2 newRoom: 180))
			(
				(and
					(not (gEgo script?))
					(not (proc819_5 334))
					(< (-- local21) 0)
				)
				(= local21 600)
				(gEgo setScript: (ScriptID 124 0))
			)
		)
		(if
			(or
				(and
					(!= (gLongSong number?) 120)
					(== (gLongSong prevSignal?) -1)
				)
				(== (gLongSong number?) 420)
			)
			(gLongSong
				number: 120
				loop: -1
				play: 50
				fade: 127 10 25 0
			)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: roomLook)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (gDelph script?) (gDelph setScript: 0))
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(if register
					(gEgo
						setCycle: 0
						view: 809
						setLoop: 3
						cel: 0
						setCycle: End self
					)
				)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(if register
					(= register (= register 0))
				else
					(= cycles (= cycles 1))
				)
			)
			(2
				(if (proc999_5 gSouth 200 140 160)
					(proc819_6 2)
				else
					(proc819_6)
				)
				(gEgo ignoreHorizon: setPri: 7)
				(= local0 0)
				(= local1 0)
				(if (and (gEgo has: 25) (not (proc819_5 73)))
					(= cycles (= cycles 5))
				else
					(proc0_2)
					(self dispose:)
				)
			)
			(3
				(if (not (proc819_3 121))
					((ScriptID 2 0) init: 1 0 0 17 1 self)
				else
					((ScriptID 2 0) init: 1 0 0 18 1 self)
				)
			)
			(4
				(gDelph setScript: timedTalk)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance timedTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= seconds (= seconds 60)))
			(1
				((ScriptID 2 0) init: 1 0 0 17 1 self)
				(= state (= state -1))
			)
		)
	)
)

(instance distantSwimmer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo
					setCycle: 0
					view: 809
					setLoop: (register decend?)
					setCycle: End self
					setMotion: MoveTo (register approachX?) (register approachY?) self
				)
			)
			(1 0)
			(2
				(global2 newRoom: (register newRoom:))
			)
		)
	)
)

(instance dontLeave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setHeading: 0 self)
			)
			(1
				(gDelph
					view: 831
					loop: 2
					cel: 6
					x: 170
					y: -43
					xStep: 12
					yStep: 7
					signal: 24576
					setPri: 6
					init:
				)
				(= cycles (= cycles 1))
			)
			(2
				(gEgo setHeading: 0)
				(gDelph setCycle: Walk setMotion: MoveTo 170 104 self)
			)
			(3
				((ScriptID 2 0) init: 1 0 0 11 1 self)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(5
				((ScriptID 2 0) init: 1 0 0 12 1 self)
			)
			(6
				(if (>= (++ local20) 2)
					(if (== ((Inv at: 1) owner?) 160)
						((ScriptID 2 0) init: 1 0 0 14 1 self)
					else
						(= cycles (= cycles 1))
					)
				else
					(= cycles (= cycles 2))
				)
			)
			(7
				(gDelph setMotion: MoveTo 170 -43 self)
				(gEgo setMotion: MoveTo (gEgo x?) (- (gEgo y?) 5) self)
			)
			(8 0)
			(9
				(proc0_2)
				(gDelph dispose:)
				(self dispose:)
			)
		)
	)
)

(instance NoQuorum of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(CouncilChambers approachVerbs: 0)
				((global2 obstacles?) delete: councilPoly)
				(gEgo setHeading: 180 self)
			)
			(1
				(proc819_7)
				(gDelph
					z: 0
					init:
					setPri: 6
					posn: 27 -29
					setMotion: MoveTo 86 75 self
				)
			)
			(2 (gDelph setHeading: 90 self))
			(3 (= cycles (= cycles 10)))
			(4
				((ScriptID 2 0) init: 1 0 0 13 1 self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 7 1 self)
			)
			(6
				(gDelph setMotion: MoveTo 108 75 self)
			)
			(7
				(gDelph
					setCycle: 0
					view: 834
					loop: 1
					cel: 0
					posn: 121 71
					setCycle: End self
				)
			)
			(8
				(gDelph dispose:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance NoneEscortedEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(EcoNarrator init: 3 0 0 53 self)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x?) (+ (global2 horizon?) 5) self
				)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance getCage of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 160 95 self)
			)
			(1 (gEgo setHeading: 225 self))
			(2
				(bikeCage dispose:)
				(gEgo
					setCycle: 0
					view: 126
					loop: 1
					cel: 0
					x: 136
					y: 114
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(EcoNarrator init: 3 0 0 23 self)
			)
			(4
				(proc819_6)
				(proc0_4 2 254)
				(gEgo ignoreHorizon: get: 0 x: 146 y: 106 setPri: 7)
				(proc819_3 61)
				(= cycles (= cycles 1))
			)
			(5 (gEgo setHeading: 0 self))
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance showEel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(eel startUpd: cel: 0 setCycle: End self)
			)
			(1
				(eel stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance roomLook of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(EcoNarrator init: 3 0 0 7 self)
			)
			(1
				(if
				(and (not (proc819_5 344)) (not (proc819_5 7)))
					(EcoNarrator init: 4 0 0 6 self)
				else
					(= cycles (= cycles 1))
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance councilPoly of Polygon
	(properties
		type $0002
	)
)

(instance FishApartments of SFeature
	(properties
		onMeCheck $0002
		approachX 19
		approachY 14
		lookStr 14
		newRoom 200
		decend 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 14))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance CouncilChambers of SFeature
	(properties
		onMeCheck $0104
		approachX 159
		approachY 74
		lookStr 12
		newRoom 160
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 12))
			(4
				(if
					(and
						(!= ((Inv at: 1) owner?) 160)
						(not (proc819_5 7))
					)
					(if (not local2)
						(= local2 1)
						(global2 setScript: NoQuorum)
						(self _approachVerbs: 26505)
					else
						(EcoNarrator init: 3 0 0 105)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Temple of SFeature
	(properties
		onMeCheck $0240
		approachX 307
		approachY 49
		lookStr 13
		newRoom 140
		decend 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 13))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Gardens of EcoFeature
	(properties
		onMeCheck $0008
		lookStr 8
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 8))
			(4 (EcoNarrator init: 3 0 0 9))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance oldColumns of EcoFeature
	(properties
		y 189
		onMeCheck $1400
		lookStr 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 6))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance TridentStatue of EcoFeature
	(properties
		x 213
		y 30
		onMeCheck $0010
		approachX 213
		approachY 77
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 1 4 9)
	)
	
	(method (doVerb theVerb &tmp temp0 temp1)
		(if (not global115)
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= temp0 theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(= global115 1)
					((ScriptID 125 0) init:)
					(EcoNarrator posn: 45 142 init: 3 0 0 25)
				)
				(4
					(= global115 1)
					((ScriptID 125 0) init:)
				)
				(44
					(if (== temp0 9)
						(= global115 1)
						((ScriptID 125 0) init:)
						(= temp1 (ScriptID 125 1))
						(temp1 doVerb: theVerb temp0 &rest)
					else
						(= global115 1)
						((ScriptID 125 0) init:)
					)
				)
				(else 
					(super doVerb: theVerb temp0 &rest)
				)
			)
		else
			(= temp1 (ScriptID 125 0))
			(temp1 doVerb: theVerb temp0 &rest)
		)
	)
)

(instance MidStatue of EcoFeature
	(properties
		onMeCheck $0020
		lookStr 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 4))
			(44
				(EcoNarrator init: 3 0 0 90)
			)
			(6 (EcoNarrator init: 3 0 0 90))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Olympian of EcoFeature
	(properties
		x 284
		y 136
		onMeCheck $0080
		lookStr 16
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 17))
			(44
				(EcoNarrator init: 3 0 0 90)
			)
			(6 (EcoNarrator init: 3 0 0 90))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Urns of EcoFeature
	(properties
		onMeCheck $0800
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 1))
			(4 (EcoNarrator init: 3 0 0 2))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance trident of EcoView
	(properties
		x 217
		y 44
		sightAngle 360
		view 120
		loop 5
		priority 3
		signal $4011
		lookStr 45
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 approachX: 213 approachY: 77)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if global115
					(super doVerb: theVerb &rest)
				else
					(= global115 1)
					((ScriptID 125 0) init:)
					(EcoNarrator init: 3 0 0 25)
				)
			)
			(4
				(if global115
					(if (not (gEgo has: 20))
						(global2 setScript: (ScriptID 125 2))
					else
						(super doVerb: theVerb &rest)
					)
				else
					(CueObj state: 0 cycles: 0 client: self theVerb: 1)
					(gEgo
						setMotion: PolyPath approachX (+ (gEgo z?) approachY) CueObj
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant1 of EcoProp
	(properties
		x 192
		y 189
		onMeCheck $0000
		view 120
		loop 1
		priority 14
		signal $4010
		cycleSpeed 15
		detailLevel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 10))
			(4 (EcoNarrator init: 3 0 0 11))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 291
		y 189
		onMeCheck $0000
		view 120
		cel 3
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 10))
			(4 (EcoNarrator init: 3 0 0 11))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant3 of EcoView
	(properties
		x 27
		y 189
		onMeCheck $0000
		view 120
		loop 2
		cel 3
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 10))
			(4 (EcoNarrator init: 3 0 0 11))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance bikeCage of EcoView
	(properties
		x 120
		y 135
		view 126
		loop 2
		signal $4001
		lookStr 40
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (global2 setScript: getCage))
			(6 (EcoNarrator init: 3 0 0 24))
			(44
				(EcoNarrator init: 3 0 0 87)
			)
			(2 (EcoNarrator init: 3 0 0 87))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance television of Garbage
	(properties
		x 70
		y 111
		view 120
		loop 4
		cel 9
		priority 3
		signal $0010
		flag 27
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 57))
			(4 (EcoNarrator init: 3 0 0 59))
			(6
				(EcoNarrator init: 3 0 0 58 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cart of Garbage
	(properties
		x 156
		y 109
		view 120
		loop 3
		cel 3
		priority 3
		signal $0010
		flag 28
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 63))
			(4 (EcoNarrator init: 3 0 0 64))
			(6
				(EcoNarrator init: 3 0 0 65 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance chair of Garbage
	(properties
		x 251
		y 86
		view 120
		loop 4
		cel 13
		priority 2
		signal $0010
		flag 30
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 72))
			(4 (EcoNarrator init: 3 0 0 73))
			(6
				(EcoNarrator init: 3 0 0 74 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance beachBall of Garbage
	(properties
		x 245
		y 133
		view 120
		loop 3
		cel 13
		priority 4
		signal $0010
		flag 32
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 66))
			(4 (EcoNarrator init: 3 0 0 67))
			(6
				(EcoNarrator init: 3 0 0 68 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance pipe of Garbage
	(properties
		x 54
		y 142
		approachX 50
		approachY 116
		view 120
		loop 4
		cel 4
		priority 3
		signal $0010
		flag 34
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 81))
			(4 (EcoNarrator init: 3 0 0 82))
			(6
				(EcoNarrator init: 3 0 0 83 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tricycle of Garbage
	(properties
		x 258
		y 143
		view 120
		loop 3
		cel 14
		priority 4
		signal $0010
		flag 35
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 69))
			(4 (EcoNarrator init: 3 0 0 70))
			(6
				(EcoNarrator init: 3 0 0 71 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance teddy of Garbage
	(properties
		x 76
		y 89
		view 120
		loop 4
		cel 2
		priority 3
		signal $0010
		flag 36
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 60))
			(4 (EcoNarrator init: 3 0 0 61))
			(6
				(EcoNarrator init: 3 0 0 62 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance radio of Garbage
	(properties
		x 127
		y 102
		view 120
		loop 4
		cel 7
		priority 3
		signal $4010
		flag 38
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 78))
			(4 (EcoNarrator init: 3 0 0 79))
			(6
				(EcoNarrator init: 3 0 0 80 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eel of EcoProp
	(properties
		x 229
		y 163
		view 120
		loop 6
		priority 15
		signal $5010
		lookStr 84
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 85))
			(1
				(if (not script) (self setScript: showEel))
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(EcoNarrator init: 3 0 0 lookStr)
	)
)
