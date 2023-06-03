;;; Sierra Script 1.0 - (do not remove this comment)
(script# 660)
(include sci.sh)
(use Main)
(use n804)
(use EcoRoom)
(use Smopper)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Osc)
(use MoveFwd)
(use ForwardCounter)
(use n958)
(use DPath)
(use Cycle)
(use Obj)

(public
	rm660 0
)

(local
	local0
	local1
)
(procedure (localproc_00e8 param1)
	(EcoNarrator init: 2 0 0 param1 self)
)

(procedure (localproc_00f8)
	(proc819_4 83)
	(gLongSong2 stop:)
	(outsideHarpoon dispose:)
	(insideHarpoon dispose:)
	(if (gCast contains: harpoonHead)
		(harpoonHead dispose:)
	)
	(eyeFeature init:)
	(finFeature init:)
	(water init:)
	(whaleMouth init:)
	(upperWhale init:)
	(mouthFeature init:)
	(gEgo
		setCycle: 0
		view: 663
		setLoop: -1
		setLoop: gStopGroop
		cel: 6
		setCycle: Smopper 664 667 0 13
		posn: 161 137
	)
	(fin init:)
	(harpoon init:)
	(eye init:)
	(if (not (proc819_5 85))
		(eye hide: setScript: eyeScript)
	else
		(eye cel: 2 stopUpd:)
	)
)

(procedure (localproc_01dc)
	(gEgo
		signal: 4096
		view: 663
		z: 0
		setLoop: -1
		setLoop: gStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 0
		setStep: 4 3
		setSpeed: 6
		setCycle: Smopper 664 667 0 13
	)
)

(instance rm660 of EcoRoom
	(properties
		picture 660
		style $000a
		horizon 10
		south 640
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(proc958_0 128 813 641 643 660)
		(Load rsFONT 310)
		(proc958_0 130 951 956 939)
		(gEgo init:)
		(self setRegions: 51)
		(if (proc819_5 132)
			(if
				(or
					(not (proc999_5 (gLongSong number?) 640 644))
					(== (gLongSong prevSignal?) -1)
				)
				(gLongSong number: 640 loop: 1 play:)
			)
			(if (or (not (proc819_5 83)) (proc819_5 140))
				(= gSouth south)
				(eye init:)
				(if (not (proc819_5 85))
					(eye hide: setScript: eyeScript)
				else
					(eye cel: 2 stopUpd:)
				)
				(eyeFeature init:)
				(finFeature init:)
				(water init:)
				(whaleMouth init:)
				(upperWhale init:)
				(mouthFeature init:)
				(localproc_01dc)
				(gEgo loop: 7 posn: 210 150)
				(fin init:)
				(harpoon cel: (proc819_5 96) init:)
			else
				(proc819_6)
				(= picture (= picture 661))
				(wound1 init:)
				(wound2 init:)
				(distanceInMouth init:)
				(teeth init:)
				(outsideOfMouth init:)
				(gLongSong2 number: 641 loop: -1 play:)
				(gEgo posn: 121 131 heading: 45 loop: 6 setPri: 7)
				(insideHarpoon init:)
				(outsideHarpoon init:)
				(self setScript: bogusScript)
			)
			(barnacles init:)
			(if (and (proc819_5 96) (not (proc819_5 88)))
				(gEgo setScript: cleanWoundTimer)
			)
			(cond 
				((proc819_5 140) 0)
				((proc819_5 90)
					(gEgo posn: 273 189 setLoop: 0)
					(self setScript: crashIntoMouth)
				)
				((not (proc819_5 85)) (self setScript: talkCetus))
			)
		else
			(gLongSong2 number: 660 loop: -1 play:)
			(harpoon init:)
			(gEgo
				setCycle: 0
				view: 663
				setLoop: 3
				cel: 6
				setCycle: Walk
				posn: 172 207
			)
			(self setScript: enterScript)
		)
		(super init: &rest)
	)
	
	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(if (> global87 0) (Palette palANIMATE 33 42 7))
		(cond 
			(script (script doit:))
			((& temp0 $0002) (global2 newRoom: 640))
			((== (gEgo edgeHit?) 3) (self setScript: leaveRoom))
			((proc999_5 (gEgo edgeHit?) 4 2) (self setScript: stayAndHelp))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((proc819_5 83) (EcoNarrator init: 3 0 0 8))
					((and (proc819_5 85) (not (proc819_5 88))) (EcoNarrator init: 3 0 0 33))
					(else (EcoNarrator init: 3 0 0 2))
				)
			)
			(4
				(if (proc819_5 83)
					(EcoNarrator init: 3 0 0 55)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(6 (EcoNarrator init: 3 0 0 56))
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 58)
					)
					(37
						(EcoNarrator init: 3 0 0 42)
					)
					(17
						(EcoNarrator init: 3 0 0 42)
					)
					(else 
						(if (proc819_5 83)
							(EcoNarrator init: 3 0 0 55)
						else
							(EcoNarrator init: 3 0 0 57)
						)
					)
				)
			)
			(2
				(if (proc819_5 83)
					(EcoNarrator init: 3 0 0 27)
				else
					(EcoNarrator init: 3 0 0 32)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gEgo setScript: 0)
		(gLongSong2 stop:)
		(proc819_4 83)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(proc0_2)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(proc819_3 90)
				(proc819_3 132)
				(= cycles (= cycles 1))
			)
			(1
				(EcoNarrator init: 3 0 0 45 self)
			)
			(2
				(gEgo setMotion: MoveTo 172 157 self)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 6 1 self)
			)
			(4
				(gEgo
					view: 660
					setLoop: 1
					cel: 0
					posn: 173 156
					setCycle: End self
				)
			)
			(5
				(gSoundEffects number: 165 loop: 1 play:)
				(ShakeScreen 8 2)
				(= cycles (= cycles 2))
			)
			(6 (global2 newRoom: 640))
		)
	)
)

(instance leaveRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo (gEgo x?) 220 self)
			)
			(1 (global2 newRoom: 640))
		)
	)
)

(instance bogusScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= cycles (= cycles 3)))
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance stayAndHelp of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setMotion: 0)
				(EcoNarrator init: 0 0 23 self)
			)
			(1
				(proc819_9 gEgo 160 (gEgo y?) self)
			)
			(2
				(gEgo setMotion: MoveFwd 20 self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance crashIntoMouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo
					setCycle: 0
					view: 660
					setLoop: 0
					setCycle: Walk
					setStep: 7 6
					setMotion: MoveTo 219 140 self
				)
			)
			(1
				(gSoundEffects number: 165 loop: 1 play:)
				(ShakeScreen 4 2)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(2 (global2 newRoom: 640))
		)
	)
)

(instance talkCetus of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_4 10 343)
				(proc819_3 85)
				(= seconds (= seconds 3))
			)
			(1
				((ScriptID 2 1) init: 1 0 0 1 1 self)
			)
			(2 (localproc_00e8 1))
			(3
				((ScriptID 2 1) init: 1 0 0 2 1 self)
			)
			(4 (localproc_00e8 2))
			(5
				((ScriptID 2 1) init: 1 0 0 3 1 self)
			)
			(6 (localproc_00e8 3))
			(7
				(EcoNarrator init: 3 0 0 35 self)
			)
			(8
				(EcoNarrator init: 3 0 0 36 self)
			)
			(9
				(eye show: cel: 0 setScript: 0 setCycle: End self)
			)
			(10 (= seconds (= seconds 3)))
			(11 (proc0_2) (self dispose:))
		)
	)
)

(instance secondTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(= cycles (= cycles 2))
			)
			(1
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(2 (localproc_00e8 4))
			(3
				((ScriptID 2 1) init: 1 0 0 5 1 self)
			)
			(4
				(eye
					posn: 119 73
					view: 662
					loop: 5
					cel: 0
					setCycle: End self
				)
			)
			(5 (= cycles (= cycles 15)))
			(6 (localproc_00e8 5))
			(7 (global2 newRoom: 600))
		)
	)
)

(instance eyeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(= seconds (= seconds (Random 5 10)))
			)
			(1
				(eye show: cel: 1)
				(= cycles (= cycles (eye cycleSpeed?)))
			)
			(2
				(eye hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance throwBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc819_3 90)
				(ShakeScreen 5 3)
				(= cycles (= cycles 2))
			)
			(1 (global2 newRoom: 640))
		)
	)
)

(instance cutHarpoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setHeading: 90 self)
			)
			(1 (= cycles (= cycles 10)))
			(2
				(insideHarpoon hide: cel: 1)
				(harpoonHead posn: 132 57 init:)
				(gEgo
					setCycle: 0
					view: 641
					loop: 2
					cel: 0
					x: 114
					y: 68
					cycleSpeed: 10
				)
				(= cycles (= cycles 1))
			)
			(3
				(if (<= (++ local1) 8)
					(-- state)
					(gSoundEffects number: 661 loop: 1 play:)
					(gEgo cel: 0 setCycle: End self)
				else
					(= cycles (= cycles 1))
				)
			)
			(4
				(gEgo setCycle: Beg)
				(proc819_3 86)
				(outsideHarpoon _approachVerbs: 0)
				(client setScript: harpoonFalls)
			)
		)
	)
)

(instance harpoonFalls of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(insideHarpoon show: stopUpd:)
				(proc819_3 87)
				(proc819_3 131)
				(gLongSong2 number: 662 loop: 1 play:)
				(harpoonHead setCycle: Fwd setMotion: MoveTo 141 130 self)
			)
			(1
				(harpoonHead
					setCycle: 0
					cel: 3
					setMotion: DPath 145 136 150 140 157 150 160 200 self
				)
			)
			(2
				(harpoonHead dispose:)
				(proc819_6 0)
				(gEgo setPri: 7 posn: 105 70)
				(EcoNarrator store: 37 init: 3 0 0 20)
				(proc0_4 5 340)
				(= cycles (= cycles 2))
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance removeHarpoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(proc819_4 131)
				(if register
					(gEgo setMotion: MoveTo 83 99 self)
				else
					(self changeState: 2)
				)
			)
			(1
				(= register (= register 0))
				(global2 drawPic: 660 10)
				(localproc_00f8)
				(= cycles (= cycles 2))
			)
			(2
				(proc0_4 5 341)
				(gEgo setMotion: MoveTo 144 124 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 643
					loop: 0
					cel: 0
					x: 132
					y: 124
					cycleSpeed: 10
					illegalBits: 0
				)
				(= cycles (= cycles 2))
			)
			(4
				(EcoNarrator init: 3 0 0 21 self)
			)
			(5
				(gSoundEffects number: 663 loop: 1 play:)
				(gEgo setCycle: End self)
				(proc819_3 96)
				(harpoon cel: 1 forceUpd:)
			)
			(6
				(localproc_01dc)
				(gEgo loop: 2 posn: 138 123 setScript: cleanWoundTimer)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance cleanWoundTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= seconds (= seconds 60)))
			(1
				(EcoNarrator init: 3 0 0 34 self)
				(= state (= state -1))
			)
		)
	)
)

(instance medicateWound of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setScript: 0 setMotion: MoveTo 138 123 self)
			)
			(1 (= cycles (= cycles 12)))
			(2
				(gEgo
					setCycle: 0
					view: 643
					setLoop: 1
					cel: 0
					posn: 145 118
					cycleSpeed: 10
				)
				(= cycles (= cycles 2))
			)
			(3 (gEgo setCycle: End self))
			(4
				(if (not local0)
					(EcoNarrator posn: -1 10 init: 3 0 0 22 self)
				else
					(= ticks (= ticks 5))
				)
			)
			(5
				(gEgo setLoop: 3 cel: 0 setCycle: ForwardCounter 7 self)
			)
			(6
				(if (< (++ local0) 3)
					(self changeState: 2)
				else
					(proc0_4 5 342)
					(proc819_3 88)
					(localproc_01dc)
					(gEgo put: 3 loop: 1 posn: 140 119 setHeading: 0 self)
				)
			)
			(7 (= cycles (= cycles 12)))
			(8 (eye setCycle: CT 1 -1 self))
			(9 (eye setCycle: Osc 1 self))
			(10
				(eye stopUpd:)
				(global2 setScript: secondTalk)
			)
		)
	)
)

(instance barnacles of EcoFeature
	(properties
		onMeCheck $4000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 83)
					(EcoNarrator init: 3 0 0 23)
				else
					(EcoNarrator init: 3 0 0 38)
				)
			)
			(4 (EcoNarrator init: 3 0 0 16))
			(44
				(EcoNarrator init: 3 0 0 16)
			)
			(2 (upperWhale doVerb: 2 &rest))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eyeFeature of EcoFeature
	(properties
		onMeCheck $2000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (proc819_5 85) (not (proc819_5 88)))
					(EcoNarrator init: 3 0 0 33)
				else
					(EcoNarrator init: 3 0 0 2)
				)
			)
			(4
				(if (and (proc819_5 85) (not (proc819_5 88)))
					(EcoNarrator init: 3 0 0 31)
				else
					(upperWhale doVerb: 4 &rest)
				)
			)
			(2 (upperWhale doVerb: 2 &rest))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance finFeature of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (upperWhale doVerb: 4 &rest))
			(2 (upperWhale doVerb: 2 &rest))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of EcoFeature
	(properties
		onMeCheck $0800
		lookStr 2
	)
)

(instance whaleMouth of EcoFeature
	(properties
		onMeCheck $0400
		lookStr 6
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(cond 
					((not (proc819_5 86)) (EcoNarrator init: 3 0 0 39))
					((proc819_5 96) (EcoNarrator init: 3 0 0 52))
					(else (upperWhale doVerb: 4 temp0 &rest))
				)
			)
			(2
				(upperWhale doVerb: 2 temp0 &rest)
			)
			(44
				(if (not (proc819_5 96))
					(switch temp0
						(29
							(EcoNarrator init: 3 0 0 50)
						)
						(else 
							(EcoNarrator init: 3 0 0 51)
						)
					)
				else
					(EcoNarrator init: 3 0 0 52)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance upperWhale of EcoFeature
	(properties
		onMeCheck $0300
		lookStr 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (and (proc819_5 85) (not (proc819_5 88)))
					(EcoNarrator init: 3 0 0 33)
				else
					(EcoNarrator init: 3 0 0 2)
				)
			)
			(4 (EcoNarrator init: 3 0 0 5))
			(2
				(if (not (proc819_5 85))
					(global2 setScript: talkCetus)
				else
					(EcoNarrator init: 3 0 0 32)
				)
			)
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 58)
					)
					(37
						(EcoNarrator init: 3 0 0 42)
					)
					(17
						(EcoNarrator init: 3 0 0 42)
					)
					(else 
						(EcoNarrator init: 3 0 0 57)
					)
				)
			)
			(6 (EcoNarrator init: 3 0 0 56))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance insideHarpoon of EcoView
	(properties
		x 116
		y 65
		approachX 105
		approachY 70
		view 641
		loop 4
		priority 7
		signal $4011
	)
	
	(method (init)
		(if (proc819_5 86) (= cel (= cel (+ cel 1))))
		(super init: &rest)
		(self approachVerbs: 9 4)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 86)
					(EcoNarrator init: 3 0 0 18)
				else
					(EcoNarrator init: 3 0 0 12)
				)
			)
			(4
				(if (proc819_5 86)
					(EcoNarrator init: 3 0 0 24)
				else
					(EcoNarrator init: 3 0 0 13)
				)
			)
			(44
				(switch temp0
					(37
						(if (not (proc819_5 86))
							(global2 setScript: cutHarpoon)
						else
							(EcoNarrator init: 3 0 0 40)
						)
					)
					(12
						(EcoNarrator init: 3 0 0 14)
					)
					(17
						(EcoNarrator init: 3 0 0 41)
					)
					(else 
						(EcoNarrator init: 3 0 0 59)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance outsideHarpoon of EcoView
	(properties
		x 66
		y 81
		approachX 105
		approachY 70
		view 641
		loop 4
		cel 2
		priority 6
		signal $4011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
		(if (not (gEgo has: 28)) (self approachVerbs: 4))
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 86)
					(EcoNarrator init: 3 0 0 18)
				else
					(EcoNarrator init: 3 0 0 12)
				)
			)
			(4
				(if (proc819_5 86)
					(global2 setScript: removeHarpoon 0 1)
				else
					(EcoNarrator init: 3 0 0 13)
				)
			)
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 14)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fin of EcoProp
	(properties
		x 18
		y 70
		onMeCheck $0000
		view 660
		loop 3
		signal $4010
		cycleSpeed 25
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)
)

(instance eye of EcoProp
	(properties
		x 139
		y 63
		onMeCheck $0000
		view 660
		loop 2
		signal $4010
		cycleSpeed 25
		detailLevel 2
	)
)

(instance harpoon of EcoView
	(properties
		x 146
		y 107
		view 643
		loop 2
		signal $4011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((not (proc819_5 86)) (EcoNarrator init: 3 0 0 46))
					((proc819_5 96) (EcoNarrator init: 3 0 0 15))
					(else (EcoNarrator init: 3 0 0 18))
				)
			)
			(4
				(cond 
					((not (proc819_5 86)) (EcoNarrator init: 3 0 0 47))
					((not (proc819_5 96)) (global2 setScript: removeHarpoon))
					(else (EcoNarrator init: 3 0 0 44))
				)
			)
			(44
				(switch temp0
					(12
						(if cel
							(global2 setScript: medicateWound)
						else
							(EcoNarrator init: 3 0 0 14)
						)
					)
					(37
						(cond 
							((not (proc819_5 86)) (EcoNarrator init: 3 0 0 48))
							(cel (EcoNarrator init: 3 0 0 42))
							(else (EcoNarrator init: 3 0 0 40))
						)
					)
					(17
						(cond 
							((not (proc819_5 86)) (EcoNarrator init: 3 0 0 48))
							(cel (EcoNarrator init: 3 0 0 42))
							(else (EcoNarrator init: 3 0 0 41))
						)
					)
					(else 
						(if cel
							(EcoNarrator init: 3 0 0 43)
						else
							(EcoNarrator init: 3 0 0 59)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wound1 of EcoFeature
	(properties
		x 73
		y 77
		nsTop 73
		nsLeft 68
		nsBottom 82
		nsRight 78
		sightAngle 90
		lookStr 14
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 86)
					(EcoNarrator init: 3 0 0 18)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 14)
					)
					(else 
						(EcoNarrator init: 3 0 0 43)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wound2 of EcoFeature
	(properties
		x 107
		y 66
		nsTop 61
		nsLeft 102
		nsBottom 71
		nsRight 112
		sightAngle 90
		lookStr 14
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 86)
					(EcoNarrator init: 3 0 0 18)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 14)
					)
					(else 
						(EcoNarrator init: 3 0 0 43)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance distanceInMouth of EcoFeature
	(properties
		onMeCheck $1000
	)
	
	(method (init)
		(super init: &rest)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (global2 script?))
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(or
					(== (gIconBar curIcon?) (gIconBar at: 0))
					(== (gIconBar curIcon?) (gIconBar at: 2))
				)
				(self onMe: pEvent)
			)
			(EcoNarrator init: 3 0 0 17)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance teeth of EcoFeature
	(properties
		onMeCheck $2000
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(if (proc999_5 theVerb 4 9)
			(EcoNarrator init: 3 0 0 26)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance harpoonHead of EcoActor
	(properties
		x 124
		y 65
		sightAngle 45
		approachX 157
		approachY 154
		yStep 4
		view 641
		loop 3
		priority 1
		signal $4810
		cycleSpeed 5
		xStep 5
		moveSpeed 5
	)
)

(instance mouthFeature of EcoFeature
	(properties
		onMeCheck $0040
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (and (proc819_5 85) (not (proc819_5 88)))
					(EcoNarrator init: 3 0 0 33)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4
				(if (not (proc819_5 86))
					(EcoNarrator init: 3 0 0 39)
				else
					(EcoNarrator init: 3 0 0 51)
				)
			)
			(44
				(if (not (proc819_5 86))
					(if (== temp0 29)
						(EcoNarrator init: 3 0 0 50)
					else
						(EcoNarrator init: 3 0 0 51)
					)
				else
					(EcoNarrator init: 3 0 0 52)
				)
			)
			(else 
				(upperWhale doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance outsideOfMouth of EcoFeature
	(properties
		onMeCheck $0002
		lookStr 53
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 54))
			(44
				(EcoNarrator init: 3 0 0 54)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
