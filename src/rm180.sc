;;; Sierra Script 1.0 - (do not remove this comment)
(script# 180)
(include sci.sh)
(use Main)
(use EcoRoom)
(use Garbage)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use DPath)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm180 0
)

(local
	[local0 12] = [-1 -1 -340 60 14 -20 90 340 105 80 210 -32768]
	[local12 16] = [-1 0 240 -20 14 -20 60 270 77 8192 -1 340 97 -20 83 -32768]
	[local28 20] = [-1 1 -340 105 14 45 120 8192 -1 340 120 -20 75 50 67 8192 -1 340 30 -32768]
)
(instance rm180 of EcoRoom
	(properties
		picture 180
		style $000a
		horizon 20
		north 200
		east 120
		walkOffTop 1
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(proc819_6)
		(gEgo init: setPri: 7)
		(shell init:)
		(whale init:)
		(leftBackGround init:)
		(rightBackGround init:)
		(yellowCoral init:)
		(columnsAtRight init:)
		(redStarFish init:)
		(cobbleStone init:)
		(moss init:)
		(gCast
			add:
				sneaker
				beerCan
				book
				container
				tire
				purse
				fishingPole
				sixPack
				wheel
				windex
			eachElementDo: #init
		)
		(plantLeft setCycle: Fwd init:)
		(plantRight setCycle: Fwd init:)
		(if
			(and
				(not (proc819_5 999)) ; TODO: this is wrong. Flag 999 overflows the designated flag range and is stored in global214
									  ; global214 is set to 18 during game init, but doesn't appear to be used anywhere.
									  ; Need to figure out the max number of flags and switch 999 to the first available unused flag.
				(not (Random 0 2))
			)
			(fishEasterEgg init:)
		)
		(if (not (proc819_5 8)) (oilOnWhale init: stopUpd:))
		(if
			(and
				(not (gEgo has: 22))
				(not (== ((Inv at: 22) owner?) 160))
				(proc819_5 8)
			)
			(superflShell init: posn: 141 116)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 319 189 0 189 0 0 13 0 13 181 319 180
					yourself:
				)
		)
		(if (== gSouth 120) (gEgo y: 96))
		(super init:)
		(self setRegions: 51 50)
		((ScriptID 50 0) addFish: @local12 @local28 @local0)
		(if (!= (gLongSong number?) 180)
			(gLongSong number: 180 loop: -1 play:)
		)
		(self setRegions: 51)
		(if (== ((Inv at: 21) owner?) 226)
			(oil0 addToPic:)
			(oil1 addToPic:)
			(oil2 addToPic:)
			(oil3 addToPic:)
			(oil4 addToPic:)
			(oil5 addToPic:)
			(oil6 addToPic:)
			(oil7 addToPic:)
			(oil8 addToPic:)
			(oil9 addToPic:)
			(oil10 addToPic:)
			(oil11 addToPic:)
			(oil12 addToPic:)
			(oil13 addToPic:)
			(oil14 addToPic:)
		)
	)
	
	(method (doit)
		(super doit:)
		(Palette palANIMATE 33 43 6)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 347)
					(EcoNarrator init: 3 0 0 97)
				else
					(EcoNarrator init: 3 0 0 6)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong2 stop: flags: 0)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(if (== gSouth 200)
			(proc0_2)
		else
			(self setScript: enterScript)
		)
		(gEgo ignoreHorizon:)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 267 87 self)
			)
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance clearOil of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(proc0_4 10 270)
				(gEgo setMotion: PolyPath 198 18 self)
			)
			(1
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 10))))
							)
						)
					)
				)
			)
			(2
				((ScriptID 2 1) init: 1 0 0 1 1 self)
			)
			(3
				(gLongSong2 number: 184 loop: -1 flags: 1 play:)
				(gEgo
					setCycle: 0
					view: 181
					loop: 0
					cel: 0
					x: 160
					y: 36
					setPri: 12
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(EcoNarrator init: 3 0 0 68 self)
			)
			(5
				(oilOnWhale cycleSpeed: 140 setCycle: CT 5 1 oilOnWhale)
				(gEgo put: 13 0)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(6
				(proc819_6)
				(gEgo
					setPri: 7
					setHeading: 90
					posn: 180 40
					ignoreHorizon:
					setMotion: DPath 197 32 217 34 227 42 231 107 210 130 178 134 178 120 self
				)
			)
			(7 (gEgo setHeading: 0 self))
			(8
				(EcoNarrator init: 3 0 0 1 self)
			)
			(9
				(proc819_3 28)
				(demeter setScript: demeterExitShell self)
			)
			(10
				(demeter
					view: 182
					loop: 1
					cel: 0
					setPri: 14
					setCycle: End self
				)
			)
			(11
				(gSoundEffects number: 185 loop: 1 flags: 1 play:)
				(= seconds
					(= seconds
						(= seconds
							(= seconds
								(= seconds (= seconds (= seconds (= seconds 2))))
							)
						)
					)
				)
			)
			(12
				(demeter setPri: 1 setCycle: Beg self)
			)
			(13
				(gEgo setMotion: MoveTo 203 132 self)
			)
			(14 (gEgo setHeading: 270 self))
			(15
				(Demeter init: 2 0 0 1 1 self)
			)
			(16
				(proc0_2)
				(gSoundEffects flags: 0)
				(demeter setScript: demeterDemands)
				(self dispose:)
			)
		)
	)
)

(instance demeterExitShell of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc819_3 32)
				(gSoundEffects number: 603 loop: 1 play:)
				(demeter
					init:
					view: 187
					loop: 0
					cel: 0
					posn: 157 133
					setPri: 3
					setCycle: End self
				)
			)
			(1
				(demeter
					setCycle: 0
					view: 186
					setLoop: 0
					cel: 0
					posn: 154 135
					setCycle: Walk
					setMotion: MoveTo 151 142 self
				)
			)
			(2
				(gSoundEffects stop:)
				(demeter stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance demeterEnterShell of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(proc819_4 32)
				(gSoundEffects number: 603 loop: 1 play:)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(1
				(demeter
					view: 186
					setLoop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 154 135 self
				)
			)
			(2
				(demeter
					setCycle: 0
					view: 187
					setLoop: 0
					cel: 6
					posn: 157 133
					setCycle: Beg self
				)
			)
			(3
				(gSoundEffects stop:)
				(demeter dispose:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance demeterDemands of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(= seconds
					(= seconds
						(= seconds
							(= seconds
								(= seconds (= seconds (= seconds (= seconds 10))))
							)
						)
					)
				)
			)
			(1
				(Demeter init: 2 0 0 9 1 self)
			)
			(2
				(= seconds
					(= seconds
						(= seconds
							(= seconds
								(= seconds (= seconds (= seconds (= seconds 30))))
							)
						)
					)
				)
			)
			(3
				(Demeter init: 2 0 0 10 1 self)
			)
			(4
				(demeter setScript: demeterEnterShell self)
			)
			(5 (self dispose:))
		)
	)
)

(instance talkToDemeter of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(proc0_4 2 271)
				(demeterDemands dispose:)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 3 1 self)
			)
			(2
				(Demeter init: 2 0 0 2 1 self)
			)
			(3
				(Demeter init: 2 0 0 3 1 self)
			)
			(4
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(5
				(Demeter init: 2 0 0 4 1 self)
			)
			(6
				((ScriptID 2 1) init: 1 0 0 5 1 self)
			)
			(7
				(Demeter init: 2 0 0 12 0 self)
			)
			(8
				(Demeter init: 2 0 0 5 1 self)
			)
			(9
				((ScriptID 2 1) init: 1 0 0 6 1 self)
			)
			(10
				(Demeter init: 2 0 0 6 1 self)
			)
			(11
				(proc819_3 27)
				(demeter hide:)
				(gEgo
					setCycle: 0
					view: 182
					loop: 0
					cel: 0
					x: 151
					y: 141
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(12
				(demeter show:)
				(proc819_6 1)
				(gEgo ignoreHorizon: posn: 203 132 setPri: 7)
				(gEgo get: 3)
				(proc0_4 2 274)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(13
				((ScriptID 2 1) init: 1 0 0 7 1 self)
			)
			(14
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(15
				(Demeter init: 2 0 0 7 0 self)
			)
			(16
				(Demeter init: 2 0 0 13 1 self)
			)
			(17
				((ScriptID 2 1) init: 1 0 0 8 1 self)
			)
			(18
				(Demeter init: 2 0 0 8 1 self)
			)
			(19
				(demeter setScript: demeterEnterShell)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(20
				(proc0_1)
				(proc819_3 8)
				(oilOnWhale cel: 6 setCycle: End)
				(superflShell
					init:
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 145 125 self
				)
			)
			(21 (proc0_2) (self dispose:))
		)
	)
)

(instance backAgain of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(demeter setScript: demeterExitShell self)
			)
			(1
				(Demeter init: 2 0 0 11 1 self)
			)
			(2
				(demeter setScript: demeterDemands)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance getSuperflShell of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(proc0_4 2 272)
				(gEgo setPri: 14 setMotion: MoveTo 144 75 self)
			)
			(1
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 10))))
							)
						)
					)
				)
			)
			(2
				(gEgo
					setCycle: 0
					view: 181
					loop: 1
					cel: 0
					x: 145
					y: 101
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(3
				(superflShell dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(proc819_6 2)
				(= global235 0)
				(gEgo ignoreHorizon: get: 22 posn: 142 109 setPri: 7)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 12))))
							)
						)
					)
				)
			)
			(5
				(EcoNarrator init: 3 0 0 2 self)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance throwOutDemeter of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(1
				(Demeter init: 2 0 0 14 1 self)
			)
			(2
				((ScriptID 2 1) init: 1 0 0 10 1 self)
			)
			(3
				(Demeter init: 2 0 0 15 1 self)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance talkOnShell of Script
	(properties)
	
	(method (changeState newState)
		(switch
			(= state
				(= state
					(= state
						(= state
							(= state (= state (= state (= state newState))))
						)
					)
				)
			)
			(0
				(proc0_1)
				(= cycles
					(= cycles
						(= cycles
							(= cycles
								(= cycles (= cycles (= cycles (= cycles 1))))
							)
						)
					)
				)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 9 1 self)
			)
			(2
				(if (and (proc819_5 270) (not (proc819_5 27)))
					(global2 setScript: backAgain)
				else
					(EcoNarrator init: 3 0 0 23 self)
				)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance demeter of EcoActor
	(properties
		x 179
		y 121
		approachX 203
		approachY 132
		view 186
		priority 3
		signal $5010
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 2 9)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (proc819_5 27))
					(EcoNarrator init: 3 0 0 12)
				else
					(EcoNarrator init: 3 0 0 14)
				)
			)
			(4 (EcoNarrator init: 3 0 0 13))
			(2
				(global2 setScript: talkToDemeter)
			)
			(6
				(global2 setScript: throwOutDemeter)
			)
			(44 (Demeter init: 2 0 0 16 1))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plantLeft of EcoProp
	(properties
		x 82
		y 134
		view 180
		signal $4010
		cycleSpeed 14
		detailLevel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 56))
			(4 (EcoNarrator init: 3 0 0 57))
			(2 (EcoNarrator init: 3 0 0 62))
			(6 (EcoNarrator init: 3 0 0 58))
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 59)
					)
					(22
						(EcoNarrator init: 3 0 0 75)
					)
					(else 
						(EcoNarrator init: 3 0 0 57)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plantRight of EcoProp
	(properties
		x 222
		y 128
		view 180
		loop 1
		cel 3
		signal $4010
		cycleSpeed 13
		detailLevel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plantLeft doVerb: theVerb temp0 &rest)
	)
)

(instance oilOnWhale of EcoProp
	(properties
		x 157
		y 46
		approachX 234
		approachY 55
		view 183
		loop 1
		priority 5
		signal $5010
		cycleSpeed 4
	)
	
	(method (init)
		(if (proc819_5 270)
			(= cel
				(= cel
					(= cel (= cel (= cel (= cel (= cel (= cel 5))))))
				)
			)
		)
		(super init: &rest)
		(self approachVerbs: 1 4)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(whale doVerb: theVerb temp0 &rest)
	)
	
	(method (cue)
		(self stopUpd:)
	)
)

(instance shell of EcoFeature
	(properties
		x 173
		y 108
		onMeCheck $0002
		approachX 206
		approachY 123
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (proc819_5 27))
					(EcoNarrator init: 3 0 0 7)
				else
					(EcoNarrator init: 3 0 0 15)
				)
			)
			(4
				(cond 
					((not (proc819_5 270)) (EcoNarrator init: 3 0 0 21))
					((gCast contains: demeter) (EcoNarrator init: 3 0 0 16))
					((proc819_5 27) (EcoNarrator init: 3 0 0 17))
					((and (proc819_5 270) (not (gEgo has: 3))) (EcoNarrator init: 3 0 0 72))
					(else (global2 setScript: backAgain))
				)
			)
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(2
				(cond 
					((proc819_5 27) (EcoNarrator init: 3 0 0 17))
					((not (gCast contains: demeter)) (global2 setScript: talkOnShell))
					(else (EcoNarrator init: 3 0 0 71))
				)
			)
			(6 (EcoNarrator init: 3 0 0 70))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance whale of EcoFeature
	(properties
		onMeCheck $0004
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (proc819_5 270))
					(EcoNarrator store: 9 init: 3 0 0 8)
				else
					(EcoNarrator store: 19 init: 3 0 0 18)
				)
			)
			(4
				(if (not (proc819_5 270))
					(EcoNarrator init: 3 0 0 10)
				else
					(EcoNarrator init: 3 0 0 78)
				)
			)
			(44
				(switch temp0
					(22
						(global2 setScript: clearOil)
					)
					(else 
						(EcoNarrator init: 3 0 0 11)
					)
				)
			)
			(2
				(if (not (proc819_5 270))
					((ScriptID 2 1) init: 1 0 0 11 1)
				else
					((ScriptID 2 1) init: 1 0 0 12 1)
				)
			)
			(6 (EcoNarrator init: 3 0 0 69))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance leftBackGround of EcoFeature
	(properties
		onMeCheck $0008
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 63))
			(4 (EcoNarrator init: 3 0 0 64))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightBackGround of EcoFeature
	(properties
		onMeCheck $0010
	)
	
	(method (doVerb theVerb)
		(leftBackGround doVerb: theVerb &rest)
	)
)

(instance yellowCoral of EcoFeature
	(properties
		onMeCheck $0020
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plantLeft doVerb: theVerb temp0 &rest)
	)
)

(instance columnsAtRight of EcoFeature
	(properties
		onMeCheck $0040
		lookStr 65
	)
	
	(method (doVerb theVerb)
		(cond 
			((proc999_5 theVerb 4 9) (EcoNarrator init: 3 0 0 66))
			((== theVerb 6) (EcoNarrator init: 3 0 0 67))
			(else (super doVerb: theVerb &rest))
		)
	)
)

(instance redStarFish of EcoFeature
	(properties
		onMeCheck $0080
		lookStr 65
	)
)

(instance cobbleStone of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 54
	)
	
	(method (doVerb theVerb)
		(if (proc999_5 theVerb 4 9 6)
			(EcoNarrator init: 3 0 0 55)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance moss of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 60
	)
	
	(method (doVerb theVerb)
		(if (proc999_5 theVerb 4 9)
			(EcoNarrator init: 3 0 0 61)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance oil0 of EcoView
	(properties
		x 82
		y 100
		sightAngle 90
		view 184
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil1 of EcoView
	(properties
		x 232
		y 101
		sightAngle 90
		view 184
		cel 1
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil2 of EcoView
	(properties
		x 72
		y 64
		sightAngle 90
		view 184
		cel 2
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil3 of EcoView
	(properties
		x 220
		y 59
		sightAngle 90
		view 184
		cel 3
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil4 of EcoView
	(properties
		x 34
		y 99
		sightAngle 90
		view 184
		cel 4
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil5 of EcoView
	(properties
		x 52
		y 185
		sightAngle 90
		view 184
		cel 5
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil6 of EcoView
	(properties
		x 175
		y 121
		sightAngle 90
		onMeCheck $0000
		view 184
		cel 6
		priority 4
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil7 of EcoView
	(properties
		x 212
		y 111
		sightAngle 90
		view 184
		cel 7
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil8 of EcoView
	(properties
		x 262
		y 82
		sightAngle 90
		view 184
		cel 8
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil9 of EcoView
	(properties
		x 286
		y 185
		sightAngle 90
		view 184
		cel 9
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil10 of EcoView
	(properties
		x 150
		y 102
		sightAngle 90
		view 184
		cel 10
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil11 of EcoView
	(properties
		x 218
		y 126
		sightAngle 90
		view 184
		cel 11
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil12 of EcoView
	(properties
		x 233
		y 180
		sightAngle 90
		view 184
		cel 12
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil13 of EcoView
	(properties
		x 90
		y 141
		sightAngle 90
		view 184
		cel 13
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance oil14 of EcoView
	(properties
		x 105
		y 94
		sightAngle 90
		view 184
		cel 14
		priority 1
		signal $5011
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance sneaker of Garbage
	(properties
		x 177
		y 146
		view 180
		loop 2
		cel 1
		flag 6
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 33))
			(4 (EcoNarrator init: 3 0 0 34))
			(6
				(EcoNarrator init: 3 0 0 35 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance beerCan of Garbage
	(properties
		x 176
		y 172
		view 180
		loop 2
		cel 2
		flag 7
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 36))
			(4 (EcoNarrator init: 3 0 0 37))
			(6
				(EcoNarrator init: 3 0 0 38 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance book of Garbage
	(properties
		x 138
		y 131
		view 180
		loop 2
		cel 3
		flag 8
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 43))
			(4 (EcoNarrator init: 3 0 0 44))
			(6
				(EcoNarrator init: 3 0 0 45 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance container of Garbage
	(properties
		x 57
		y 138
		view 180
		loop 2
		cel 4
		flag 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 48))
			(4 (EcoNarrator init: 3 0 0 49))
			(6
				(EcoNarrator init: 3 0 0 50 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tire of Garbage
	(properties
		x 171
		y 122
		view 180
		loop 2
		cel 5
		priority 5
		signal $0010
		flag 10
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 39))
			(4 (EcoNarrator init: 3 0 0 46))
			(6
				(EcoNarrator init: 3 0 0 47 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance purse of Garbage
	(properties
		x 93
		y 143
		view 180
		loop 2
		cel 6
		flag 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 40))
			(4 (EcoNarrator init: 3 0 0 41))
			(6
				(EcoNarrator init: 3 0 0 42 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fishingPole of Garbage
	(properties
		x 173
		y 134
		approachX 129
		approachY 128
		view 180
		loop 2
		cel 7
		flag 12
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 30))
			(4 (EcoNarrator init: 3 0 0 31))
			(6
				(EcoNarrator init: 3 0 0 32 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance sixPack of Garbage
	(properties
		x 208
		y 169
		view 180
		loop 2
		cel 8
		flag 13
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 27))
			(4 (EcoNarrator init: 3 0 0 28))
			(6
				(EcoNarrator init: 3 0 0 29 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wheel of Garbage
	(properties
		x 117
		y 137
		view 180
		loop 2
		cel 9
		flag 14
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 24))
			(4 (EcoNarrator init: 3 0 0 25))
			(6
				(EcoNarrator init: 3 0 0 26 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance windex of Garbage
	(properties
		x 135
		y 148
		view 180
		loop 2
		cel 10
		flag 15
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 51))
			(4 (EcoNarrator init: 3 0 0 52))
			(6
				(EcoNarrator init: 3 0 0 53 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance superflShell of EcoActor
	(properties
		x 146
		y 71
		approachX 142
		approachY 145
		view 183
		loop 2
		priority 4
		signal $5010
		cycleSpeed 7
		illegalBits $0000
		moveSpeed 5
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 2 9)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 20))
			(4
				(global2 setScript: getSuperflShell)
			)
			(6 (EcoNarrator init: 3 0 0 3))
			(44
				(switch temp0
					(42
						(EcoNarrator init: 3 0 0 76)
					)
					(else 
						(EcoNarrator init: 3 0 0 77)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Demeter of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 185
		charNum 18
		keepWindow 1
	)
	
	(method (init)
		(super init: demBust demEyes demMouth &rest)
	)
)

(instance demBust of EcoProp
	(properties
		view 185
	)
)

(instance demEyes of EcoProp
	(properties
		nsTop 16
		nsLeft 13
		view 185
		loop 2
		cycleSpeed 30
	)
)

(instance demMouth of EcoProp
	(properties
		nsTop 21
		nsLeft 16
		view 185
		loop 1
		cycleSpeed 10
	)
)

(instance fishEasterEgg of EcoActor
	(properties
		x 286
		y 183
		view 104
		detailLevel 1
		illegalBits $0000
		xStep 4
	)
	
	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 1
			setPri: 12
			setCycle: Fwd
			cycleSpeed: 16
			setHeading: 100
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (self doEgg:))
			(44 (self doEgg:))
			(6 (self doEgg:))
			(1 (self doEgg:))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (doEgg)
		(if (and (== (self x?) 286) (== (self y?) 183))
			(proc819_3 999) ; TODO: fix this to match the new flag number when the bug rm180::init is fixed.
			(gSoundEffects number: 104 play:)
			(DoAudio 7 11025)
			(self setMotion: MoveTo -50 160)
		)
	)
)
